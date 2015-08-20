package co.edu.uniandes.csw.marketplace.persistence;

import co.edu.uniandes.csw.marketplace.entities.ProviderEntity;
import java.util.HashMap;
import java.util.Map;
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
    
    public ProviderEntity getProviderByUserId(String userId){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user_id", userId);
        return this.executeSingleNamedQuery("Provider.getByUserId", params);
    }
}
