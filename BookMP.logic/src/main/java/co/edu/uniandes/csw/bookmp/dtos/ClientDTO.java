package co.edu.uniandes.csw.bookmp.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @generated
 */
@XmlRootElement 
public class ClientDTO {

    private Long id;
    private String name;
    private String phone;
    private String idCard;
    private String email;
    private String userId;
    private List<CartItemDTO> shoppingcart;
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
    public String getIdCard() {
        return idCard;
    }

    /**
     * @generated
     */
    public void setIdCard(String idcard) {
        this.idCard = idcard;
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
    public List<CartItemDTO> getShoppingcart() {
        return shoppingcart;
    }

    /**
     * @generated
     */
    public void setShoppingcart(List<CartItemDTO> shoppingcart) {
        this.shoppingcart = shoppingcart;
    }

}
