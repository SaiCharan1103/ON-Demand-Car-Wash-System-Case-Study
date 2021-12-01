package CaseStudy.UserService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Id
	private int UserId;
	private String UserName;
	private String UserPhone;
	private String UserEmail;
	private String UserAddress;
	private String UserPassword;
	//Constructor
	public User(int userId, String userName, String userPhone, String userEmail, String userAddress,
			String userPassword) {
		UserId = userId;
		UserName = userName;
		UserPhone = userPhone;
		UserEmail = userEmail;
		UserAddress = userAddress;
		UserPassword = userPassword;
	}
	//user method with no args
	public User() {
		
	}
    //Getters and Setters
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPhone() {
		return UserPhone;
	}

	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getUserAddress() {
		return UserAddress;
	}

	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	//To String
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", UserPhone=" + UserPhone + ", UserEmail="
				+ UserEmail + ", UserAddress=" + UserAddress + ", UserPassword=" + UserPassword + "]";
	}
}
