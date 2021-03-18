package com.ltts.project.model;

import java.sql.Date;

public class Complaint {
	private String complaintId;
	private String complaintType;
	private String complaintIncharge;
	private Date dateOfRequest;
	private String request;
	private String complaintDescription;
	public String getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public String getComplaintIncharge() {
		return complaintIncharge;
	}
	public void setComplaintIncharge(String complaintIncharge) {
		this.complaintIncharge = complaintIncharge;
	}
	public Date getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getComplaintDescription() {
		return complaintDescription;
	}
	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}
	public Complaint(String complaintId, String complaintType, String complaintIncharge, Date dateOfRequest,
			String request, String complaintDescription) {
		super();
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.complaintIncharge = complaintIncharge;
		this.dateOfRequest = dateOfRequest;
		this.request = request;
		this.complaintDescription = complaintDescription;
	}
	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", complaintType=" + complaintType + ", complaintIncharge="
				+ complaintIncharge + ", dateOfRequest=" + dateOfRequest + ", request=" + request
				+ ", complaintDescription=" + complaintDescription + "]";
	}
	
	
}
