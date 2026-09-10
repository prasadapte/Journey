package DTO;

public class DebtRequestBody {

	private String leadId;
	private PersonalDetails personalDetails;
	private DebitCardDetails debitCardDetails;
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public DebitCardDetails getDebitCardDetails() {
		return debitCardDetails;
	}
	public void setDebitCardDetails(DebitCardDetails debitCardDetails) {
		this.debitCardDetails = debitCardDetails;
	}
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

}
