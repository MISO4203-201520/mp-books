/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.IClientLogic;
import co.edu.uniandes.csw.marketplace.utils.StormpathService;
import co.edu.uniandes.csw.marketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.marketplace.dtos.UserDTO;
import com.stormpath.sdk.account.Account;
import com.google.gson.Gson;
import com.stormpath.sdk.resource.ResourceException;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author Jhonatan
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class UserService {

    @Inject
    private IClientLogic clientLogic;

    @Path("/login")
    @POST
    public Response login(UserDTO user) {
        try {
            List<ClientDTO> alreadyClient;
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(), user.isRememberMe());
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            alreadyClient = clientLogic.findByName(user.getUserName());
            if (!alreadyClient.isEmpty()) {
                currentUser.getSession().setAttribute("ClientId", alreadyClient.get(0));
                return Response.status(Response.Status.OK).entity(alreadyClient.get(0)).build();
            } else {
                return Response.status(Response.Status.CONFLICT).build();
            }
        } catch (AuthenticationException e) {
            Gson json = new Gson();
            return Response.status(Response.Status.UNAUTHORIZED).entity(json.toJson(e.getMessage())).build();
        }
    }

    @Path("/logout")
    @GET
    public Response logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/currentUser")
    @GET
    public Response getCurrentUser() {
        UserDTO user = new UserDTO();
        try {
            Subject currentUser = SecurityUtils.getSubject();
            Map<String, String> userAttributes = (Map<String, String>) currentUser.getPrincipals().oneByType(java.util.Map.class);
            user.setName(userAttributes.get("givenName") + " " + userAttributes.get("surname"));
            user.setEmail(userAttributes.get("email"));
            user.setUserName(userAttributes.get("username"));
            return Response.status(Response.Status.OK).entity(user).build();
        } catch (AuthenticationException e) {
            Gson json = new Gson();
            return Response.status(Response.Status.BAD_REQUEST).entity(json.toJson(e.getMessage())).build();
        }
    }

    @Path("/register")
    @POST
    public Response setUser(UserDTO user) {

        try {
            Account acct = StormpathService.createUserClient(user);
            ClientDTO newClient = new ClientDTO();
            newClient.setName(user.getUserName());
            newClient.setUserId(acct.getHref());
            newClient = clientLogic.createClient(newClient);
            return Response.status(Response.Status.OK).build();
        } catch (ResourceException e) {
            Gson json = new Gson();
            return Response.status(e.getStatus()).entity(json.toJson(e.getMessage())).build();
        }
    }

}
