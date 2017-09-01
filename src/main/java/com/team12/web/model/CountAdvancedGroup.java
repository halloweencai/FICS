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
 * CountAdvancedGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="countadvancedgroupinfo"
    ,catalog="fcis"
)

public class CountAdvancedGroup  implements java.io.Serializable {


    // Fields    

     private Date year;
     private Integer countryAdvancedProductionCompanyNumber;
     private Integer countryMayDayAwardCompanyNumber;
     private Integer provinceAdvancedProductionCompanyNumber;
     private Integer siChuanMayDayCompanyNumber;
     private Integer countryPioneerWorkerNumber;
     private Integer siChuanPioneerWorkerNumber;
     private Integer cityPioneerWorkerNumber;
     private Integer companyPioneerWorkerNumber;


    // Constructors

    /** default constructor */
    public CountAdvancedGroup() {
    }

	/** minimal constructor */
    public CountAdvancedGroup(Date year) {
        this.year = year;
    }
    
    /** full constructor */
    public CountAdvancedGroup(Date year, Integer countryAdvancedProductionCompanyNumber, Integer countryMayDayAwardCompanyNumber, Integer provinceAdvancedProductionCompanyNumber, Integer siChuanMayDayCompanyNumber, Integer countryPioneerWorkerNumber, Integer siChuanPioneerWorkerNumber, Integer cityPioneerWorkerNumber, Integer companyPioneerWorkerNumber) {
        this.year = year;
        this.countryAdvancedProductionCompanyNumber = countryAdvancedProductionCompanyNumber;
        this.countryMayDayAwardCompanyNumber = countryMayDayAwardCompanyNumber;
        this.provinceAdvancedProductionCompanyNumber = provinceAdvancedProductionCompanyNumber;
        this.siChuanMayDayCompanyNumber = siChuanMayDayCompanyNumber;
        this.countryPioneerWorkerNumber = countryPioneerWorkerNumber;
        this.siChuanPioneerWorkerNumber = siChuanPioneerWorkerNumber;
        this.cityPioneerWorkerNumber = cityPioneerWorkerNumber;
        this.companyPioneerWorkerNumber = companyPioneerWorkerNumber;
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
    
    @Column(name="countryAdvancedProductionCompanyNumber")

    public Integer getCountryAdvancedProductionCompanyNumber() {
        return this.countryAdvancedProductionCompanyNumber;
    }
    
    public void setCountryAdvancedProductionCompanyNumber(Integer countryAdvancedProductionCompanyNumber) {
        this.countryAdvancedProductionCompanyNumber = countryAdvancedProductionCompanyNumber;
    }
    
    @Column(name="countryMayDayAwardCompanyNumber")

    public Integer getCountryMayDayAwardCompanyNumber() {
        return this.countryMayDayAwardCompanyNumber;
    }
    
    public void setCountryMayDayAwardCompanyNumber(Integer countryMayDayAwardCompanyNumber) {
        this.countryMayDayAwardCompanyNumber = countryMayDayAwardCompanyNumber;
    }
    
    @Column(name="provinceAdvancedProductionCompanyNumber")

    public Integer getProvinceAdvancedProductionCompanyNumber() {
        return this.provinceAdvancedProductionCompanyNumber;
    }
    
    public void setProvinceAdvancedProductionCompanyNumber(Integer provinceAdvancedProductionCompanyNumber) {
        this.provinceAdvancedProductionCompanyNumber = provinceAdvancedProductionCompanyNumber;
    }
    
    @Column(name="siChuanMayDayCompanyNumber")

    public Integer getSiChuanMayDayCompanyNumber() {
        return this.siChuanMayDayCompanyNumber;
    }
    
    public void setSiChuanMayDayCompanyNumber(Integer siChuanMayDayCompanyNumber) {
        this.siChuanMayDayCompanyNumber = siChuanMayDayCompanyNumber;
    }
    
    @Column(name="countryPioneerWorkerNumber")

    public Integer getCountryPioneerWorkerNumber() {
        return this.countryPioneerWorkerNumber;
    }
    
    public void setCountryPioneerWorkerNumber(Integer countryPioneerWorkerNumber) {
        this.countryPioneerWorkerNumber = countryPioneerWorkerNumber;
    }
    
    @Column(name="siChuanPioneerWorkerNumber")

    public Integer getSiChuanPioneerWorkerNumber() {
        return this.siChuanPioneerWorkerNumber;
    }
    
    public void setSiChuanPioneerWorkerNumber(Integer siChuanPioneerWorkerNumber) {
        this.siChuanPioneerWorkerNumber = siChuanPioneerWorkerNumber;
    }
    
    @Column(name="cityPioneerWorkerNumber")

    public Integer getCityPioneerWorkerNumber() {
        return this.cityPioneerWorkerNumber;
    }
    
    public void setCityPioneerWorkerNumber(Integer cityPioneerWorkerNumber) {
        this.cityPioneerWorkerNumber = cityPioneerWorkerNumber;
    }
    
    @Column(name="companyPioneerWorkerNumber")

    public Integer getCompanyPioneerWorkerNumber() {
        return this.companyPioneerWorkerNumber;
    }
    
    public void setCompanyPioneerWorkerNumber(Integer companyPioneerWorkerNumber) {
        this.companyPioneerWorkerNumber = companyPioneerWorkerNumber;
    }
   








}