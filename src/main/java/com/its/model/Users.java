package com.its.model;
// Generated Jun 12, 2014 10:19:05 AM by Hibernate Tools 3.6.0

import java.util.Date;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Users generated by hbm2java
 */
public class Users implements java.io.Serializable {

    private Integer id;
    @Size(min = 6, max = 15, message = "Password must between 6 and 15 characters.")
    private String password;
    @NotEmpty(message = "Email address may not be empty.")
    @Email(message = "Please provide a valid email address.")
    private String email;    
    private Date createdAt;
    private Date updatedAt;
    private String message;
    private boolean success = false;

    public Users() {
    }

    public Users(String email, String password, Date createdAt, Date updatedAt) {
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
