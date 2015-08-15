package co.edu.uniandes.csw.marketplace.providers;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;

@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {
    
    @Override
    public void filter(ContainerRequestContext req) throws IOException, AuthenticationException {
        req.getHeaders().remove("X-UserId");
        Object userId = SecurityUtils.getSubject().getPrincipal();
        if (userId != null) {
            req.getHeaders().add("X-UserId", userId.toString());
        }
    }
}
