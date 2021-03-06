package co.edu.uniandes.csw.marketplace.services;

import co.edu.uniandes.csw.marketplace.api.ICartItemLogic;
import co.edu.uniandes.csw.marketplace.api.IClientLogic;
import co.edu.uniandes.csw.marketplace.dtos.CartItemDTO;
import co.edu.uniandes.csw.marketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.marketplace.providers.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    @Inject
    private IClientLogic clientLogic;
    
    private ClientDTO client = (ClientDTO)SecurityUtils.getSubject().getSession().getAttribute("Client");

    /**
     * @generated
     */
    @POST
    @StatusCreated
    public CartItemDTO createCartItem(CartItemDTO dto) {
        return cartItemLogic.createCartItemByClient(dto, client.getId());
    }

    /**
     * @generated
     */
    @GET
    public List<CartItemDTO> getCartItems() {
//        if (page != null && maxRecords != null) {
//            this.response.setIntHeader("X-Total-Count", cartItemLogic.countCartItemsByClient(currentClient.getId()));
//        }
//        return cartItemLogic.getCartItemsByClient(page, maxRecords, currentClient.getId());
        return clientLogic.getClient(client.getId()).getShoppingcart();
    }

    /**
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public CartItemDTO getCartItemDTO(@PathParam("id") Long id) {
        return cartItemLogic.getCartItemsByClientById(id, client.getId());
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public CartItemDTO updateCartItem(@PathParam("id") Long id, CartItemDTO dto) {
        dto.setId(id);
        return cartItemLogic.updateCartItemByClient(client.getId(), dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCartItem(@PathParam("id") Long id) {
        cartItemLogic.deleteCartItemByClient(client.getId(), id);
    }
}
