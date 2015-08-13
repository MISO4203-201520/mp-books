package co.edu.uniandes.csw.bookmp.dtos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @generated
 */
@XmlRootElement 
public class EditorialDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String userId;
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

}
