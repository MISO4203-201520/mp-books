package co.edu.uniandes.csw.marketplace.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

/**
 * @generated
 */
@Entity
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Client")
    private Long id;

    private String name;

    private String phone;

    private String idCard;

    private String email;

    private String userId;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItemEntity> shoppingcart;
    /**
     * @generated
     */
    public Long getId(){
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName(){
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * @generated
     */
    public String getPhone(){
        return phone;
    }

    /**
     * @generated
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * @generated
     */
    public String getIdCard(){
        return idCard;
    }

    /**
     * @generated
     */
    public void setIdCard(String idCard){
        this.idCard = idCard;
    }

    /**
     * @generated
     */
    public String getEmail(){
        return email;
    }

    /**
     * @generated
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * @generated
     */
    public String getUserId(){
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * @generated
     */
    public List<CartItemEntity> getShoppingcart() {
        return shoppingcart;
    }

    /**
     * @generated
     */
    public void setShoppingcart(List<CartItemEntity> shoppingcart) {
        this.shoppingcart = shoppingcart;
    }

}
