package co.edu.uniandes.csw.bookmp.ejbs;

import co.edu.uniandes.csw.bookmp.api.IEditorialLogic;
import co.edu.uniandes.csw.bookmp.converters.EditorialConverter;
import co.edu.uniandes.csw.bookmp.dtos.EditorialDTO;
import co.edu.uniandes.csw.bookmp.entities.EditorialEntity;
import co.edu.uniandes.csw.bookmp.persistence.EditorialPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @generated
 */
@Stateless
public class EditorialLogic implements IEditorialLogic {

    @Inject private EditorialPersistence persistence;

    /**
     * @generated
     */
    public int countEditorials() {
        return persistence.count();
    }

    /**
     * @generated
     */
    public List<EditorialDTO> getEditorials(Integer page, Integer maxRecords) {
        return EditorialConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public EditorialDTO getEditorial(Long id) {
        return EditorialConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * @generated
     */
    public EditorialDTO createEditorial(EditorialDTO dto) {
        EditorialEntity entity = EditorialConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return EditorialConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public EditorialDTO updateEditorial(EditorialDTO dto) {
        EditorialEntity entity = persistence.update(EditorialConverter.fullDTO2Entity(dto));
        return EditorialConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteEditorial(Long id) {
        persistence.delete(id);
    }

    /**
     * @generated
     */
    public List<EditorialDTO> findByName(String name) {
        return EditorialConverter.listEntity2DTO(persistence.findByName(name));
    }
}
