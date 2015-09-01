package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IProductLogic;
import co.edu.uniandes.csw.marketplace.converters.ProductConverter;
import co.edu.uniandes.csw.marketplace.dtos.ProductDTO;
import co.edu.uniandes.csw.marketplace.entities.ProductEntity;
import co.edu.uniandes.csw.marketplace.persistence.ProductPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class ProductLogic implements IProductLogic {

    @Inject private ProductPersistence persistence;

    /**
     * @generated
     */
    public int countProducts() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<ProductDTO> getProducts(Integer page, Integer maxRecords) {
        return ProductConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ProductDTO getProduct(Long id) {
        return ProductConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public ProductDTO createProduct(ProductDTO dto) {
        ProductEntity entity = ProductConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return ProductConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ProductDTO updateProduct(ProductDTO dto) {
        ProductEntity entity = persistence.update(ProductConverter.fullDTO2Entity(dto));
        return ProductConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteProduct(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<ProductDTO> findByName(String name) {
        return ProductConverter.listEntity2DTO(persistence.findByName(name));
    }
    
    public List<ProductDTO> getByBookName(String name){
        return ProductConverter.listEntity2DTO(persistence.getByBookName(name));
    }
    
    public ProductDTO getCheapestProduct(Long idBook){       
        return ProductConverter.fullEntity2DTO(persistence.getCheapestProduct(idBook));
    }
}
