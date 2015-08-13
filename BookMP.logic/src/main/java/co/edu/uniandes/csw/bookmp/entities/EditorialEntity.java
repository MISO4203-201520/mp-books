package co.edu.uniandes.csw.bookmp.entities;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

/**
 * @generated
 */
@Entity
public class EditorialEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "Editorial")
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String userId;

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
    public String getUserId(){
        return userId;
    }

    /**
     * @generated
     */
    public void setUserId(String userId){
        this.userId = userId;
    }

}
