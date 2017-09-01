package com.team12.web.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * SystemUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="systemuser"
    ,catalog="fcis"
)

public class SystemUser  implements java.io.Serializable {


    // Fields    

     private String user;
     private String password;
     private Integer userPermission;
     private String userUnit;
     private String email;
     private String sex;
     private String idnumber;
     private long telephoneNumber;


    // Constructors

    /** default constructor */
    public SystemUser() {
    }

    
    /** full constructor */
    public SystemUser(String user, String password, Integer userPermission, String userUnit, String email, String sex, String idnumber, long telephoneNumber) {
        this.user = user;
        this.password = password;
        this.userPermission = userPermission;
        this.userUnit = userUnit;
        this.email = email;
        this.sex = sex;
        this.idnumber = idnumber;
        this.telephoneNumber = telephoneNumber;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="user", unique=true, nullable=false, length=10)

    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    
    @Column(name="password", nullable=false, length=16)

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="UserPermission", nullable=false)

    public Integer getUserPermission() {
        return this.userPermission;
    }
    
    public void setUserPermission(Integer userPermission) {
        this.userPermission = userPermission;
    }
    
    @Column(name="userUnit", nullable=false, length=20)

    public String getUserUnit() {
        return this.userUnit;
    }
    
    public void setUserUnit(String userUnit) {
        this.userUnit = userUnit;
    }
    
    @Column(name="email", nullable=false, length=30)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="sex", nullable=false, length=5)

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    @Column(name="IDNumber", nullable=false, length=18)

    public String getIdnumber() {
        return this.idnumber;
    }
    
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
    
    @Column(name="telephoneNumber", nullable=false)

    public long getTelephoneNumber() {
        return this.telephoneNumber;
    }
    
    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
   








}