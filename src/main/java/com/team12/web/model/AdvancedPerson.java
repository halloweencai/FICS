package com.team12.web.model;
// default package

import com.team12.web.model.Honor;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * AdvancedPerson entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="advancedpersonalinfo"
    ,catalog="fcis"
)

public class AdvancedPerson  implements java.io.Serializable {


    // Fields    
     private String idnumber;
     private String name;
     private String sex;
     private String nation;
     private Date birthday;
     private String politicalStatus;
     private String degreeOfEducation;
     private String telephoneNumber;
     private String workplace;
     private String job;
     private String healthStatus;
     private String cityOwnedIndutries;
     private String employmentStatus;
     private String familyTrouble;
     private String outstandingDeeds;
     private String honoraryTitle;
     private String treament;
     private String modelWorkerStatus;
     private String modelWorkerTitle;
     private Set<Honor> honors = new HashSet<Honor>(0);

     // Constructors

    /** default constructor */
    public AdvancedPerson() {
    }

	/** minimal constructor */
    public AdvancedPerson(String idnumber, String name, String sex, String nation, Date birthday, String politicalStatus, String degreeOfEducation, String telephoneNumber, String workplace, String job, String cityOwnedIndutries) {
        this.idnumber = idnumber;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.politicalStatus = politicalStatus;
        this.degreeOfEducation = degreeOfEducation;
        this.telephoneNumber = telephoneNumber;
        this.workplace = workplace;
        this.job = job;
        this.cityOwnedIndutries = cityOwnedIndutries;
    }
    
    /** full constructor */
    public AdvancedPerson(String idnumber, String name, String sex, String nation, Date birthday, String politicalStatus, String degreeOfEducation, String telephoneNumber, String workplace, String job, String healthStatus, String cityOwnedIndutries, String employmentStatus, String familyTrouble, String outstandingDeeds, String honoraryTitle, String treament, String modelWorkerStatus, String modelWorkerTitle, Set<Honor> honors) {
        this.idnumber = idnumber;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.politicalStatus = politicalStatus;
        this.degreeOfEducation = degreeOfEducation;
        this.telephoneNumber = telephoneNumber;
        this.workplace = workplace;
        this.job = job;
        this.healthStatus = healthStatus;
        this.cityOwnedIndutries = cityOwnedIndutries;
        this.employmentStatus = employmentStatus;
        this.familyTrouble = familyTrouble;
        this.outstandingDeeds = outstandingDeeds;
        this.honoraryTitle = honoraryTitle;
        this.treament = treament;
        this.modelWorkerStatus = modelWorkerStatus;
        this.modelWorkerTitle = modelWorkerTitle;
        this.honors = honors;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="IDNumber", unique=true, nullable=false, length=18)

    public String getIdnumber() {
        return this.idnumber;
    }
    
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
    
    @Column(name="name", nullable=false, length=20)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="sex", nullable=false, length=2)

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    @Column(name="nation", nullable=false, length=20)

    public String getNation() {
        return this.nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="birthday", nullable=false, length=10)

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Column(name="politicalStatus", nullable=false, length=20)

    public String getPoliticalStatus() {
        return this.politicalStatus;
    }
    
    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }
    
    @Column(name="degreeOfEducation", nullable=false, length=20)

    public String getDegreeOfEducation() {
        return this.degreeOfEducation;
    }
    
    public void setDegreeOfEducation(String degreeOfEducation) {
        this.degreeOfEducation = degreeOfEducation;
    }
    
    @Column(name="telephoneNumber", nullable=false, length=11)

    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }
    
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    
    @Column(name="workplace", nullable=false, length=30)

    public String getWorkplace() {
        return this.workplace;
    }
    
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    
    @Column(name="job", nullable=false, length=20)

    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
    
    @Column(name="healthStatus", length=50)

    public String getHealthStatus() {
        return this.healthStatus;
    }
    
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
    
    @Column(name="cityOwnedIndutries", nullable=false, length=50)

    public String getCityOwnedIndutries() {
        return this.cityOwnedIndutries;
    }
    
    public void setCityOwnedIndutries(String cityOwnedIndutries) {
        this.cityOwnedIndutries = cityOwnedIndutries;
    }
    
    @Column(name="employmentStatus", length=10)

    public String getEmploymentStatus() {
        return this.employmentStatus;
    }
    
    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
    
    @Column(name="familyTrouble", length=65535)

    public String getFamilyTrouble() {
        return this.familyTrouble;
    }
    
    public void setFamilyTrouble(String familyTrouble) {
        this.familyTrouble = familyTrouble;
    }
    
    @Column(name="outstandingDeeds", length=65535)

    public String getOutstandingDeeds() {
        return this.outstandingDeeds;
    }
    
    public void setOutstandingDeeds(String outstandingDeeds) {
        this.outstandingDeeds = outstandingDeeds;
    }
    
    @Column(name="honoraryTitle", length=20)

    public String getHonoraryTitle() {
        return this.honoraryTitle;
    }
    
    public void setHonoraryTitle(String honoraryTitle) {
        this.honoraryTitle = honoraryTitle;
    }
    
    @Column(name="treament", length=20)

    public String getTreament() {
        return this.treament;
    }
    
    public void setTreament(String treament) {
        this.treament = treament;
    }
    
    @Column(name="modelWorkerStatus", length=10)

    public String getModelWorkerStatus() {
        return this.modelWorkerStatus;
    }
    
    public void setModelWorkerStatus(String modelWorkerStatus) {
        this.modelWorkerStatus = modelWorkerStatus;
    }
    
    @Column(name="modelWorkerTitle", length=20)

    public String getModelWorkerTitle() {
        return this.modelWorkerTitle;
    }
    
    public void setModelWorkerTitle(String modelWorkerTitle) {
        this.modelWorkerTitle = modelWorkerTitle;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="advancedPerson")

    public Set<Honor> getHonors() {
        return this.honors;
    }
    
    public void setHonors(Set<Honor> honors) {
        this.honors = honors;
    }
   








}