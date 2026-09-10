package com.sbi.yono.JointAccountMS.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cstmr_onbrdng")
public class CustomerOnboarding {
	@Id
	@Column(name = "\"leadId\"")
	private String leadId;
	private String pan_dtls;
	private String cardname;
	
	public CustomerOnboarding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	public String getPan_dtls() {
		return pan_dtls;
	}

	public void setPan_dtls(String pan_dtls) {
		this.pan_dtls = pan_dtls;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	
	public CustomerOnboarding(String leadId, String pan_dtls, String cardname) {
		super();
		this.leadId = leadId;
		this.pan_dtls = pan_dtls;
		this.cardname = cardname;
	}
	
	
}
