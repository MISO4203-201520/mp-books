package co.edu.uniandes.csw.marketplace.persistence;

import co.edu.uniandes.csw.marketplace.entities.BookEntity;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class BookPersistence extends CrudPersistence<BookEntity> {

    /**
     * @generated
     */
    public BookPersistence() {
        this.entityClass = BookEntity.class;
    }
}
