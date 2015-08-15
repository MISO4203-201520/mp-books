package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.ICartItemLogic;
import co.edu.uniandes.csw.marketplace.converters.CartItemConverter;
import co.edu.uniandes.csw.marketplace.dtos.CartItemDTO;
import co.edu.uniandes.csw.marketplace.entities.CartItemEntity;
import co.edu.uniandes.csw.marketplace.persistence.CartItemPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

/**
 * @generated
 */
@Stateless
public class CartItemLogic implements ICartItemLogic {

    @Inject
    private CartItemPersistence persistence;

    /**
     * @generated
     */
    public int countCartItems() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<CartItemDTO> getCartItems(Integer page, Integer maxRecords) {
        return CartItemConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public CartItemDTO getCartItem(Long id) {
        return CartItemConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public CartItemDTO createCartItem(CartItemDTO dto) {
        CartItemEntity entity = CartItemConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return CartItemConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public CartItemDTO updateCartItem(CartItemDTO dto) {
        CartItemEntity entity = persistence.update(CartItemConverter.fullDTO2Entity(dto));
        return CartItemConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteCartItem(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<CartItemDTO> findByName(String name) {
        return CartItemConverter.listEntity2DTO(persistence.findByName(name));
    }

    public List<CartItemDTO> getCartItemsByClient(Integer page, Integer maxRecords, Long idClient) {
        return persistence.getCartItemsByClient(page, maxRecords, idClient);
    }

    public CartItemDTO createCartItemByClient(CartItemDTO dto, Long idClient) {
        return persistence.createCartItemByClient(dto, idClient);
    }

    public CartItemDTO getCartItemsByClientById(Long id, Long idClient) {
        return persistence.getCartItemsByClientById(idClient, idClient);
    }

    public CartItemDTO updateCartItemByClient(Long idClient, CartItemDTO dto) {
        CartItemDTO result = new CartItemDTO();
        if (dto.getClient().getId().equals(idClient)) {
            result = updateCartItem(dto);
        }
        return result;
    }

    public void deleteCartItemByClient(Long idClient, Long id) {
        persistence.deleteCartItemByClient(idClient, id);
    }

    public int countCartItemsByClient(Long idClient) {
        return persistence.countByClient(idClient);
    }

}
