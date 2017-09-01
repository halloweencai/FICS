package com.team12.web.model;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * CountAdvancedPerson entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="countadvancedpersonalinfo"
    ,catalog="fcis"
)

public class CountAdvancedPerson  implements java.io.Serializable {


    // Fields    

     private Date year;
     private Integer allPersonNumber;
     private Integer deadAdvancedPersonNum;
     private Integer retireAdvancedPersonNum;
     private Integer workingAdvancedPersonNum;
     private Integer companyLeaderNum;
     private Integer institutionLeaderNum;
     private Integer companyModelWorkerNum;
     private Integer institutionModelWorkerNum;
     private Integer staffModelWorkerNum;
     private Integer agricultureModelWorkerNum;
     private Integer privateCompanyModelWorkerNum;


    // Constructors

    /** default constructor */
    public CountAdvancedPerson() {
    }

	/** minimal constructor */
    public CountAdvancedPerson(Date year) {
        this.year = year;
    }
    
    /** full constructor */
    public CountAdvancedPerson(Date year, Integer allPersonNumber, Integer deadAdvancedPersonNum, Integer retireAdvancedPersonNum, Integer workingAdvancedPersonNum, Integer companyLeaderNum, Integer institutionLeaderNum, Integer companyModelWorkerNum, Integer institutionModelWorkerNum, Integer staffModelWorkerNum, Integer agricultureModelWorkerNum, Integer privateCompanyModelWorkerNum) {
        this.year = year;
        this.allPersonNumber = allPersonNumber;
        this.deadAdvancedPersonNum = deadAdvancedPersonNum;
        this.retireAdvancedPersonNum = retireAdvancedPersonNum;
        this.workingAdvancedPersonNum = workingAdvancedPersonNum;
        this.companyLeaderNum = companyLeaderNum;
        this.institutionLeaderNum = institutionLeaderNum;
        this.companyModelWorkerNum = companyModelWorkerNum;
        this.institutionModelWorkerNum = institutionModelWorkerNum;
        this.staffModelWorkerNum = staffModelWorkerNum;
        this.agricultureModelWorkerNum = agricultureModelWorkerNum;
        this.privateCompanyModelWorkerNum = privateCompanyModelWorkerNum;
    }

   
    // Property accessors
    @Id 
    @Temporal(TemporalType.DATE)
    @Column(name="year", unique=true, nullable=false, length=10)

    public Date getYear() {
        return this.year;
    }
    
    public void setYear(Date year) {
        this.year = year;
    }
    
    @Column(name="allPersonNumber")

    public Integer getAllPersonNumber() {
        return this.allPersonNumber;
    }
    
    public void setAllPersonNumber(Integer allPersonNumber) {
        this.allPersonNumber = allPersonNumber;
    }
    
    @Column(name="deadAdvancedPersonNum")

    public Integer getDeadAdvancedPersonNum() {
        return this.deadAdvancedPersonNum;
    }
    
    public void setDeadAdvancedPersonNum(Integer deadAdvancedPersonNum) {
        this.deadAdvancedPersonNum = deadAdvancedPersonNum;
    }
    
    @Column(name="retireAdvancedPersonNum")

    public Integer getRetireAdvancedPersonNum() {
        return this.retireAdvancedPersonNum;
    }
    
    public void setRetireAdvancedPersonNum(Integer retireAdvancedPersonNum) {
        this.retireAdvancedPersonNum = retireAdvancedPersonNum;
    }
    
    @Column(name="workingAdvancedPersonNum")

    public Integer getWorkingAdvancedPersonNum() {
        return this.workingAdvancedPersonNum;
    }
    
    public void setWorkingAdvancedPersonNum(Integer workingAdvancedPersonNum) {
        this.workingAdvancedPersonNum = workingAdvancedPersonNum;
    }
    
    @Column(name="companyLeaderNum")

    public Integer getCompanyLeaderNum() {
        return this.companyLeaderNum;
    }
    
    public void setCompanyLeaderNum(Integer companyLeaderNum) {
        this.companyLeaderNum = companyLeaderNum;
    }
    
    @Column(name="institutionLeaderNum")

    public Integer getInstitutionLeaderNum() {
        return this.institutionLeaderNum;
    }
    
    public void setInstitutionLeaderNum(Integer institutionLeaderNum) {
        this.institutionLeaderNum = institutionLeaderNum;
    }
    
    @Column(name="companyModelWorkerNum")

    public Integer getCompanyModelWorkerNum() {
        return this.companyModelWorkerNum;
    }
    
    public void setCompanyModelWorkerNum(Integer companyModelWorkerNum) {
        this.companyModelWorkerNum = companyModelWorkerNum;
    }
    
    @Column(name="institutionModelWorkerNum")

    public Integer getInstitutionModelWorkerNum() {
        return this.institutionModelWorkerNum;
    }
    
    public void setInstitutionModelWorkerNum(Integer institutionModelWorkerNum) {
        this.institutionModelWorkerNum = institutionModelWorkerNum;
    }
    
    @Column(name="staffModelWorkerNum")

    public Integer getStaffModelWorkerNum() {
        return this.staffModelWorkerNum;
    }
    
    public void setStaffModelWorkerNum(Integer staffModelWorkerNum) {
        this.staffModelWorkerNum = staffModelWorkerNum;
    }
    
    @Column(name="agricultureModelWorkerNum")

    public Integer getAgricultureModelWorkerNum() {
        return this.agricultureModelWorkerNum;
    }
    
    public void setAgricultureModelWorkerNum(Integer agricultureModelWorkerNum) {
        this.agricultureModelWorkerNum = agricultureModelWorkerNum;
    }
    
    @Column(name="privateCompanyModelWorkerNum")

    public Integer getPrivateCompanyModelWorkerNum() {
        return this.privateCompanyModelWorkerNum;
    }
    
    public void setPrivateCompanyModelWorkerNum(Integer privateCompanyModelWorkerNum) {
        this.privateCompanyModelWorkerNum = privateCompanyModelWorkerNum;
    }
   








}