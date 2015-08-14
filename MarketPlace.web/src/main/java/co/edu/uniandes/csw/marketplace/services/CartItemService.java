package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.ICartItemLogic;
import co.edu.uniandes.csw.marketplace.dtos.CartItemDTO;
import co.edu.uniandes.csw.marketplace.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.shiro.SecurityUtils;

/**
 * @generated
 */
@Path("cartItems")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CartItemService {

    @Inject
    private ICartItemLogic cartItemLogic;
    @Context
    private HttpServletResponse response;
    @QueryParam("page")
    private Integer page;
    @QueryParam("maxRecords")
    private Integer maxRecords;
    @PathParam("idClient")
    private Long idClient;
    @HeaderParam("X-UserId")
    private String userId;

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public CartItemDTO createCartItem(CartItemDTO dto) {
        return cartItemLogic.createCartItemByClient(dto, idClient);
    }

    /**
     * @generated
     */
    @GET
    public List<CartItemDTO> getCartItems() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", cartItemLogic.countCartItemsByClient(idClient));
        }
        return cartItemLogic.getCartItemsByClient(page, maxRecords, idClient);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public CartItemDTO getCartItemDTO(@PathParam("id") Long id) {
        return cartItemLogic.getCartItemsByClientById(id, idClient);
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public CartItemDTO updateCartItem(@PathParam("id") Long id, CartItemDTO dto) {
        dto.setId(id);
        return cartItemLogic.updateCartItemByClient(idClient, dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCartItem(@PathParam("id") Long id) {
        cartItemLogic.deleteCartItemByClient(idClient, id);
    }
}
