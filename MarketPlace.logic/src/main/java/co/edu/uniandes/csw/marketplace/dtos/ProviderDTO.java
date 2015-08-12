package co.edu.uniandes.csw.marketplace.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class ProviderDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String userId;
    private List<ProductDTO> products;
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
    public String getEmail() {
        return email;
    }

    /**
     * @generated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @generated
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userid) {
        this.userId = userid;
    }

    /**
     * @generated
     */
    public List<ProductDTO> getProducts() {
        return products;
    }

    /**
     * @generated
     */
    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

}
