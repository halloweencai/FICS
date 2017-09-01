package com.team12.web.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * DataDict entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="datadict"
    ,catalog="fcis"
)

public class DataDict  implements java.io.Serializable {


    // Fields    

     private short no;
     private String dataItem;
     private String dataType;
     private String dataStream;
     private String dataStorage;
     private String processingProcedure;


    // Constructors

    /** default constructor */
    public DataDict() {
    }

    
    /** full constructor */
    public DataDict(short no, String dataItem, String dataType, String dataStream, String dataStorage, String processingProcedure) {
        this.no = no;
        this.dataItem = dataItem;
        this.dataType = dataType;
        this.dataStream = dataStream;
        this.dataStorage = dataStorage;
        this.processingProcedure = processingProcedure;
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
    
    @Column(name="dataItem", nullable=false, length=20)

    public String getDataItem() {
        return this.dataItem;
    }
    
    public void setDataItem(String dataItem) {
        this.dataItem = dataItem;
    }
    
    @Column(name="dataType", nullable=false, length=20)

    public String getDataType() {
        return this.dataType;
    }
    
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
    @Column(name="dataStream", nullable=false, length=20)

    public String getDataStream() {
        return this.dataStream;
    }
    
    public void setDataStream(String dataStream) {
        this.dataStream = dataStream;
    }
    
    @Column(name="dataStorage", nullable=false, length=20)

    public String getDataStorage() {
        return this.dataStorage;
    }
    
    public void setDataStorage(String dataStorage) {
        this.dataStorage = dataStorage;
    }
    
    @Column(name="processingProcedure", nullable=false, length=20)

    public String getProcessingProcedure() {
        return this.processingProcedure;
    }
    
    public void setProcessingProcedure(String processingProcedure) {
        this.processingProcedure = processingProcedure;
    }
   








}