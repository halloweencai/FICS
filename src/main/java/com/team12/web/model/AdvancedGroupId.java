package com.team12.web.model;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * AdvancedGroupId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class AdvancedGroupId  implements java.io.Serializable {


    // Fields    

     private String unitName;
     private String cityOwnedIndutries;


    // Constructors

    /** default constructor */
    public AdvancedGroupId() {
    }

    
    /** full constructor */
    public AdvancedGroupId(String unitName, String cityOwnedIndutries) {
        this.unitName = unitName;
        this.cityOwnedIndutries = cityOwnedIndutries;
    }

   
    // Property accessors

    @Column(name="unitName", nullable=false, length=20)

    public String getUnitName() {
        return this.unitName;
    }
    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Column(name="cityOwnedIndutries", nullable=false, length=20)

    public String getCityOwnedIndutries() {
        return this.cityOwnedIndutries;
    }
    
    public void setCityOwnedIndutries(String cityOwnedIndutries) {
        this.cityOwnedIndutries = cityOwnedIndutries;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AdvancedGroupId) ) return false;
		 AdvancedGroupId castOther = ( AdvancedGroupId ) other; 
         
		 return ( (this.getUnitName()==castOther.getUnitName()) || ( this.getUnitName()!=null && castOther.getUnitName()!=null && this.getUnitName().equals(castOther.getUnitName()) ) )
 && ( (this.getCityOwnedIndutries()==castOther.getCityOwnedIndutries()) || ( this.getCityOwnedIndutries()!=null && castOther.getCityOwnedIndutries()!=null && this.getCityOwnedIndutries().equals(castOther.getCityOwnedIndutries()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUnitName() == null ? 0 : this.getUnitName().hashCode() );
         result = 37 * result + ( getCityOwnedIndutries() == null ? 0 : this.getCityOwnedIndutries().hashCode() );
         return result;
   }   





}