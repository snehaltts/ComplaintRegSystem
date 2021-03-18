package com.ltts.project.model;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Complaint implements Serializable {
	private String complaintType;
	private int complaintIncharge;
	private LocalDate dateOfRequest;
	private String requestStatus;
	private String complaintDescription;
	private String complaintSubject;
	
	@Id
	@GeneratedValue
	private int complaintId;
	
	
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public int getComplaintIncharge() {
		return complaintIncharge;
	}
	public void setComplaintIncharge(int complaintIncharge) {
		this.complaintIncharge = complaintIncharge;
	}
//	public Date getDateOfRequest() {
//		return dateOfRequest;
//	}
//	public void setDateOfRequest(Date dateOfRequest) {
//		this.dateOfRequest = dateOfRequest;
//	}
	public LocalDate getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(LocalDate dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public String getRequest() {
		return requestStatus;
	}
	public void setRequest(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getComplaintDescription() {
		return complaintDescription;
	}
	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}
	public Complaint(int complaintId, String complaintType, LocalDate requestDate, 
		 String complaintDescription, int complaintIncharge, String complaintSubject, String requestStatus) {
		super();
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.dateOfRequest = requestDate;
		this.complaintDescription = complaintDescription;
		this.complaintSubject = complaintSubject;
		this.complaintIncharge  = complaintIncharge;
		this.requestStatus = requestStatus;
		
	}
	
	public String getComplaintSubject() {
		return complaintSubject;
	}
	public void setComplaintSubject(String complaintSubject) {
		this.complaintSubject = complaintSubject;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", complaintType=" + complaintType + ", complaintIncharge="
				+ complaintIncharge + ", dateOfRequest=" + dateOfRequest + ", requestStatus=" + requestStatus
				+ ", complaintDescription=" + complaintDescription + ", complaintSubject=" + complaintSubject + "]";
	}
	
	
}
