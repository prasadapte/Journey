package com.sbi.yono.JointAccountMS.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="acc_onbordng")
public class AccountOnboarding {
	
	@Id
	@Column(name = "\"leadId\"")
	private String leadId;
	
	private String physicalcardtype;
	
	public AccountOnboarding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountOnboarding(String leadId, String physicalcardtype) {
		super();
		this.leadId = leadId;
		this.physicalcardtype = physicalcardtype;
	}
	
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public String getPhysicalcardtype() {
		return physicalcardtype;
	}
	public void setPhysicalcardtype(String physicalcardtype) {
		this.physicalcardtype = physicalcardtype;
	}
	
	
	
}
