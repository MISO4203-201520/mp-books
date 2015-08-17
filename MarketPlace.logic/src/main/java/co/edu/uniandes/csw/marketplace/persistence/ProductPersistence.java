package co.edu.uniandes.csw.marketplace.persistence;

import co.edu.uniandes.csw.marketplace.entities.ProductEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

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
        Query q = em.createNamedQuery("Product.getByBookName");
        q.setParameter("name", "%" + name.toUpperCase() + "%");
        return q.getResultList();
    }
}
