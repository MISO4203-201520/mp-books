package co.edu.uniandes.csw.marketplace.persistence;

import co.edu.uniandes.csw.marketplace.entities.ClientEntity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ClientPersistence extends CrudPersistence<ClientEntity> {

    /**
     * @generated
     */
    public ClientPersistence() {
        this.entityClass = ClientEntity.class;
    }
    
    public ClientEntity getClientByUserId(String userId){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user_id", userId);
        return this.executeSingleNamedQuery("Client.getByUserId", params);
    }
}
