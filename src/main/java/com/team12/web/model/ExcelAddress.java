package com.team12.web.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * ExcelAddress entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="exceladdress"
    ,catalog="fcis"
)

public class ExcelAddress  implements java.io.Serializable {


    // Fields    

     private short no;
     private String type;
     private String address;


    // Constructors

    /** default constructor */
    public ExcelAddress() {
    }

    
    /** full constructor */
    public ExcelAddress(short no, String type, String address) {
        this.no = no;
        this.type = type;
        this.address = address;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="no", unique=true, nullable=false)

    public short getNo() {
        return this.no;
    }
    
    public void setNo(short no) {
        this.no = no;
    }
    
    @Column(name="type", nullable=false, length=10)

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="address", nullable=false, length=30)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
   








}