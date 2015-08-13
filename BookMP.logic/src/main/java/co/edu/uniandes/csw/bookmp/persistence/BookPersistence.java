package co.edu.uniandes.csw.bookmp.persistence;

import co.edu.uniandes.csw.bookmp.entities.BookEntity;
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
