package co.edu.uniandes.csw.bookmp.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class CartItemDTO {

    private Long id;
    private Integer quantity;
    private String name;
    private BookDTO book;
    private ClientDTO client;
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
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @generated
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
    public BookDTO getBook() {
        return book;
    }

    /**
     * @generated
     */
    public void setBook(BookDTO book) {
        this.book = book;
    }

    /**
     * @generated
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * @generated
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

}
