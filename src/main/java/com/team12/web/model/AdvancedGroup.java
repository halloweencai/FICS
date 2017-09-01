package com.team12.web.model;
// default package

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AdvancedGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="advancedgroupinfo"
    ,catalog="fcis"
)

public class AdvancedGroup  implements java.io.Serializable {


    // Fields    

     private AdvancedGroupId id;
     private String personInCharge;
     private long telephoneNumber;
     private String outstandingDeeds;
     private String honoraryTitle;


    // Constructors

    /** default constructor */
    public AdvancedGroup() {
    }

	/** minimal constructor */
    public AdvancedGroup(AdvancedGroupId id, String personInCharge, long telephoneNumber, String honoraryTitle) {
        this.id = id;
        this.personInCharge = personInCharge;
        this.telephoneNumber = telephoneNumber;
        this.honoraryTitle = honoraryTitle;
    }
    
    /** full constructor */
    public AdvancedGroup(AdvancedGroupId id, String personInCharge, long telephoneNumber, String outstandingDeeds, String honoraryTitle) {
        this.id = id;
        this.personInCharge = personInCharge;
        this.telephoneNumber = telephoneNumber;
        this.outstandingDeeds = outstandingDeeds;
        this.honoraryTitle = honoraryTitle;
    }

   
    // Property accessors
    @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="unitName", column=@Column(name="unitName", nullable=false, length=20) ), 
        @AttributeOverride(name="cityOwnedIndutries", column=@Column(name="cityOwnedIndutries", nullable=false, length=20) ) } )

    public AdvancedGroupId getId() {
        return this.id;
    }
    
    public void setId(AdvancedGroupId id) {
        this.id = id;
    }
    
    @Column(name="personInCharge", nullable=false, length=20)

    public String getPersonInCharge() {
        return this.personInCharge;
    }
    
    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }
    
    @Column(name="telephoneNumber", nullable=false)

    public long getTelephoneNumber() {
        return this.telephoneNumber;
    }
    
    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    
    @Column(name="outstandingDeeds", length=100)

    public String getOutstandingDeeds() {
        return this.outstandingDeeds;
    }
    
    public void setOutstandingDeeds(String outstandingDeeds) {
        this.outstandingDeeds = outstandingDeeds;
    }
    
    @Column(name="honoraryTitle", nullable=false, length=20)

    public String getHonoraryTitle() {
        return this.honoraryTitle;
    }
    
    public void setHonoraryTitle(String honoraryTitle) {
        this.honoraryTitle = honoraryTitle;
    }
   








}