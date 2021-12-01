package CaseStudy.WasherService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Washer Details")
public class washer {
	@Id
	private int washerId;
	private String washerName;
	private String washerEmail;
	private String washerPhone;
	private String washerAddress;
	private String washerPassword;
	//An Empty instance of washer with no fields
	public washer() {
		
	}
	//Constructor
	public washer(int washerId, String washerName, String washerEmail, String washerPhone, String washerAddress,
			String washerPassword) {
		this.washerId = washerId;
		this.washerName = washerName;
		this.washerEmail = washerEmail;
		this.washerPhone = washerPhone;
		this.washerAddress = washerAddress;
		this.washerPassword = washerPassword;
	}
//Getters and Setters
	public int getWasherId() {
		return washerId;
	}

	public void setWasherId(int washerId) {
		this.washerId = washerId;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public String getWasherEmail() {
		return washerEmail;
	}

	public void setWasherEmail(String washerEmail) {
		this.washerEmail = washerEmail;
	}

	public String getWasherPhone() {
		return washerPhone;
	}

	public void setWasherPhone(String washerPhone) {
		this.washerPhone = washerPhone;
	}

	public String getWasherAddress() {
		return washerAddress;
	}

	public void setWasherAddress(String washerAddress) {
		this.washerAddress = washerAddress;
	}

	public String getWasherPassword() {
		return washerPassword;
	}

	public void setWasherPassword(String washerPassword) {
		this.washerPassword = washerPassword;
	}
//To String method
	@Override
	public String toString() {
		return "washer [washerId=" + washerId + ", washerName=" + washerName + ", washerEmail=" + washerEmail
				+ ", washerPhone=" + washerPhone + ", washerAddress=" + washerAddress + ", washerPassword="
				+ washerPassword + "]";
	}
}