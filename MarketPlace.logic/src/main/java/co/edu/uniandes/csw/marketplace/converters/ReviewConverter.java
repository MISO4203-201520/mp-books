/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.ReviewDTO;
import co.edu.uniandes.csw.marketplace.entities.BookEntity;
import co.edu.uniandes.csw.marketplace.entities.ReviewEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author af.esguerra10
 */
public class ReviewConverter {

    public ReviewConverter() {
    }
    
    /**
     * @param entity
     * @return
     * @generated
     */
    public static ReviewDTO refEntity2DTO(ReviewEntity entity) {
        if (entity != null) {
            ReviewDTO dto = new ReviewDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            dto.setSource(entity.getSource());

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
    public static ReviewEntity refDTO2Entity(ReviewDTO dto) {
        if (dto != null) {
            ReviewEntity entity = new ReviewEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ReviewDTO basicEntity2DTO(ReviewEntity entity) {
        if (entity != null) {
            ReviewDTO dto = new ReviewDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            dto.setSource(entity.getSource());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ReviewEntity basicDTO2Entity(ReviewDTO dto) {
        if (dto != null) {
            ReviewEntity entity = new ReviewEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setSource(dto.getSource());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ReviewDTO fullEntity2DTO(ReviewEntity entity) {
        if (entity != null) {
            ReviewDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ReviewEntity fullDTO2Entity(ReviewDTO dto) {
        if (dto != null) {
            ReviewEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */

    public static List<ReviewDTO> listEntity2DTO(List<ReviewEntity> entities) {
        List<ReviewDTO> dtos = new ArrayList<ReviewDTO>();
        if (entities != null) {
            for (ReviewEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ReviewEntity> listDTO2Entity(List<ReviewDTO> dtos) {
        List<ReviewEntity> entities = new ArrayList<ReviewEntity>();
        if (dtos != null) {
            for (ReviewDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }

    /**
     * @generated
     */
    public static ReviewEntity childDTO2Entity(ReviewDTO dto, BookEntity parent){
        ReviewEntity entity = basicDTO2Entity(dto);
        entity.setBook(parent);
        return entity;
    }

    /**
     * @generated
     */
    public static List<ReviewEntity> childListDTO2Entity(List<ReviewDTO> dtos, BookEntity parent) {
        List<ReviewEntity> entities = new ArrayList<ReviewEntity>();
        if (dtos != null) {
            for (ReviewDTO dto : dtos) {
                entities.add(childDTO2Entity(dto, parent));
            }
        }
        return entities;
    }
}
