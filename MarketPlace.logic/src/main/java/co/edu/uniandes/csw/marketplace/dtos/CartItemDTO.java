package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class CartItemDTO {

    private Long id;
    private Integer quantity;
    private String name;
    private ClientDTO client;
    private ProductDTO product;
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
    public ClientDTO getClient() {
        return client;
    }

    /**
     * @generated
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

    /**
     * @generated
     */
    public ProductDTO getProduct() {
        return product;
    }

    /**
     * @generated
     */
    public void setProduct(ProductDTO product) {
        this.product = product;
    }

}
