package com.team12.web.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Honor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "honor", catalog = "fcis")

public class Honor implements java.io.Serializable {

	// Fields

	private Integer fileNo;
	private AdvancedPerson advancedPerson;
	private String fileName;
	private String honorContent;
	private String grantUnit;
	private Date grantTime;
	private String dispatchUnit;
	private Date dispatchTime;
	private String record;
	private String honorTitleTreatment;
	private String outstandingDeeds;
	private String basisOfAsserting;
	private String advice;

	// Constructors

	/** default constructor */
	public Honor() {
	}

	/** minimal constructor */
	public Honor(Integer fileNo, String fileName, String honorContent, String grantUnit, Date grantTime,
			String dispatchUnit, Date dispatchTime, String record, String honorTitleTreatment, String outstandingDeeds,
			String basisOfAsserting, String advice) {
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.honorContent = honorContent;
		this.grantUnit = grantUnit;
		this.grantTime = grantTime;
		this.dispatchUnit = dispatchUnit;
		this.dispatchTime = dispatchTime;
		this.record = record;
		this.honorTitleTreatment = honorTitleTreatment;
		this.outstandingDeeds = outstandingDeeds;
		this.basisOfAsserting = basisOfAsserting;
		this.advice = advice;
	}

	/** full constructor */
	public Honor(Integer fileNo, AdvancedPerson advancedPerson, String fileName, String honorContent, String grantUnit,
			Date grantTime, String dispatchUnit, Date dispatchTime, String record, String honorTitleTreatment,
			String outstandingDeeds, String basisOfAsserting, String advice) {
		this.fileNo = fileNo;
		this.advancedPerson = advancedPerson;
		this.fileName = fileName;
		this.honorContent = honorContent;
		this.grantUnit = grantUnit;
		this.grantTime = grantTime;
		this.dispatchUnit = dispatchUnit;
		this.dispatchTime = dispatchTime;
		this.record = record;
		this.honorTitleTreatment = honorTitleTreatment;
		this.outstandingDeeds = outstandingDeeds;
		this.basisOfAsserting = basisOfAsserting;
		this.advice = advice;
	}

	// Property accessors
	@Id

	@Column(name = "fileNo", unique = true, nullable = false)

	public Integer getFileNo() {
		return this.fileNo;
	}

	public void setFileNo(Integer fileNo) {
		this.fileNo = fileNo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDNumber")

	public AdvancedPerson getAdvancedPerson() {
		return this.advancedPerson;
	}

	public void setAdvancedPerson(AdvancedPerson advancedPerson) {
		this.advancedPerson = advancedPerson;
	}

	@Column(name = "fileName", nullable = false, length = 20)

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "honorContent", nullable = false, length = 65535)

	public String getHonorContent() {
		return this.honorContent;
	}

	public void setHonorContent(String honorContent) {
		this.honorContent = honorContent;
	}

	@Column(name = "grantUnit", nullable = false, length = 20)

	public String getGrantUnit() {
		return this.grantUnit;
	}

	public void setGrantUnit(String grantUnit) {
		this.grantUnit = grantUnit;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "grantTime", nullable = false, length = 10)

	public Date getGrantTime() {
		return this.grantTime;
	}

	public void setGrantTime(Date grantTime) {
		this.grantTime = grantTime;
	}

	@Column(name = "dispatchUnit", nullable = false, length = 20)

	public String getDispatchUnit() {
		return this.dispatchUnit;
	}

	public void setDispatchUnit(String dispatchUnit) {
		this.dispatchUnit = dispatchUnit;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dispatchTime", nullable = false, length = 10)

	public Date getDispatchTime() {
		return this.dispatchTime;
	}

	public void setDispatchTime(Date dispatchTime) {
		this.dispatchTime = dispatchTime;
	}

	@Column(name = "record", nullable = false, length = 50)

	public String getRecord() {
		return this.record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	@Column(name = "honorTitleTreatment", nullable = false, length = 20)

	public String getHonorTitleTreatment() {
		return this.honorTitleTreatment;
	}

	public void setHonorTitleTreatment(String honorTitleTreatment) {
		this.honorTitleTreatment = honorTitleTreatment;
	}

	@Column(name = "outstandingDeeds", nullable = false, length = 65535)

	public String getOutstandingDeeds() {
		return this.outstandingDeeds;
	}

	public void setOutstandingDeeds(String outstandingDeeds) {
		this.outstandingDeeds = outstandingDeeds;
	}

	@Column(name = "basisOfAsserting", nullable = false, length = 100)

	public String getBasisOfAsserting() {
		return this.basisOfAsserting;
	}

	public void setBasisOfAsserting(String basisOfAsserting) {
		this.basisOfAsserting = basisOfAsserting;
	}

	@Column(name = "advice", nullable = false, length = 50)

	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

}