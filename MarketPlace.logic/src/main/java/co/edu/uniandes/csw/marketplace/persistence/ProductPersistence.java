package co.edu.uniandes.csw.marketplace.persistence;

import co.edu.uniandes.csw.marketplace.dtos.ProductDTO;
import co.edu.uniandes.csw.marketplace.entities.ProductEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ProductPersistence extends CrudPersistence<ProductEntity> {

    /**
     * @generated
     */
    public ProductPersistence() {
        this.entityClass = ProductEntity.class;
    }

    public List<ProductEntity> getByBookName(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", "%" + name.toUpperCase() + "%");
        return executeListNamedQuery("Product.getByBookName", params);
    }
    
    public ProductEntity getCheapestProduct (Long idBook){
        try{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idBook",idBook);
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        list = executeListNamedQuery("Product.getCheapestProduct",params);
        return list.get(0);
        }catch(NoResultException e){
            return null;
        }
    }
}
