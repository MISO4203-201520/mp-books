package co.edu.uniandes.csw.marketplace.persistence;

import co.edu.uniandes.csw.marketplace.entities.ProviderEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ProviderPersistence extends CrudPersistence<ProviderEntity> {

    /**
     * @generated
     */
    public ProviderPersistence() {
        this.entityClass = ProviderEntity.class;
    }
}