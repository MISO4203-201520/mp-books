package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class BookDTO {

    private Long id;
    private String name;
    private String description;
    private String image;
    private String isbn;
    /**
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @generated
     */
    public String getImage() {
        return image;
    }

    /**
     * @generated
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @generated
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @generated
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
