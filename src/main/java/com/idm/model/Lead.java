package com.idm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campaign_lead")
public class Lead {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	

	@Column(name = "lead_name")
	private String leadName;
	
	@Column(name = "lead_json")
	private String leadJson;
	
	@Column(name = "lead_headers")
	private String leadHeaders;
	
	@Column(name = "api_url")
	private String apiURL;
	
	
	@Column(name = "data_send")
	private Boolean dataSend;
	
	@Column(name = "response_json")
	private String responseJson;
	
	@Column(name = "response_code")
	private Integer responseCode;
	
	@Column(name = "failure_message")
	private String failureMessage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}

	public String getLeadJson() {
		return leadJson;
	}

	public void setLeadJson(String leadJson) {
		this.leadJson = leadJson;
	}

	public String getLeadHeaders() {
		return leadHeaders;
	}

	public void setLeadHeaders(String leadHeaders) {
		this.leadHeaders = leadHeaders;
	}

	public Boolean getDataSend() {
		return dataSend;
	}

	public void setDataSend(Boolean dataSend) {
		this.dataSend = dataSend;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}
	
	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}
	
	public String getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(String responseJson) {
		this.responseJson = responseJson;
	}
	
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apiURL == null) ? 0 : apiURL.hashCode());
		result = prime * result + ((dataSend == null) ? 0 : dataSend.hashCode());
		result = prime * result + ((failureMessage == null) ? 0 : failureMessage.hashCode());
		result = prime * result + id;
		result = prime * result + ((leadHeaders == null) ? 0 : leadHeaders.hashCode());
		result = prime * result + ((leadJson == null) ? 0 : leadJson.hashCode());
		result = prime * result + ((leadName == null) ? 0 : leadName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lead other = (Lead) obj;
		if (apiURL == null) {
			if (other.apiURL != null)
				return false;
		} else if (!apiURL.equals(other.apiURL))
			return false;
		if (dataSend == null) {
			if (other.dataSend != null)
				return false;
		} else if (!dataSend.equals(other.dataSend))
			return false;
		if (failureMessage == null) {
			if (other.failureMessage != null)
				return false;
		} else if (!failureMessage.equals(other.failureMessage))
			return false;
		if (id != other.id)
			return false;
		if (leadHeaders == null) {
			if (other.leadHeaders != null)
				return false;
		} else if (!leadHeaders.equals(other.leadHeaders))
			return false;
		if (leadJson == null) {
			if (other.leadJson != null)
				return false;
		} else if (!leadJson.equals(other.leadJson))
			return false;
		if (leadName == null) {
			if (other.leadName != null)
				return false;
		} else if (!leadName.equals(other.leadName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lead [id=" + id + ", leadName=" + leadName + ", leadJson=" + leadJson + ", leadHeaders=" + leadHeaders
				+ ", apiURL=" + apiURL + ", dataSend=" + dataSend + ", failureMessage=" + failureMessage + "]";
	}	
}

