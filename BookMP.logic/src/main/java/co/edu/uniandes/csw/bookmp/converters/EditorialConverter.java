package co.edu.uniandes.csw.bookmp.converters;

import co.edu.uniandes.csw.bookmp.dtos.EditorialDTO;
import co.edu.uniandes.csw.bookmp.entities.EditorialEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class EditorialConverter {

    /**
     * @generated
     */
    private EditorialConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static EditorialDTO refEntity2DTO(EditorialEntity entity) {
        if (entity != null) {
            EditorialDTO dto = new EditorialDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static EditorialEntity refDTO2Entity(EditorialDTO dto) {
        if (dto != null) {
            EditorialEntity entity = new EditorialEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static EditorialDTO basicEntity2DTO(EditorialEntity entity) {
        if (entity != null) {
            EditorialDTO dto = new EditorialDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
            dto.setPhone(entity.getPhone());
            dto.setUserId(entity.getUserId());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static EditorialEntity basicDTO2Entity(EditorialDTO dto) {
        if (dto != null) {
            EditorialEntity entity = new EditorialEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setPhone(dto.getPhone());
            entity.setUserId(dto.getUserId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static EditorialDTO fullEntity2DTO(EditorialEntity entity) {
        if (entity != null) {
            EditorialDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static EditorialEntity fullDTO2Entity(EditorialDTO dto) {
        if (dto != null) {
            EditorialEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<EditorialDTO> listEntity2DTO(List<EditorialEntity> entities) {
        List<EditorialDTO> dtos = new ArrayList<EditorialDTO>();
        if (entities != null) {
            for (EditorialEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<EditorialEntity> listDTO2Entity(List<EditorialDTO> dtos) {
        List<EditorialEntity> entities = new ArrayList<EditorialEntity>();
        if (dtos != null) {
            for (EditorialDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

}
