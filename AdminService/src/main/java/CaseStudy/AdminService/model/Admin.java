package CaseStudy.AdminService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Admins")
public class Admin {
	@Id
	private int AdminId;
	private String AdminName;
	//Constructor
	public Admin(int adminId, String adminName) {
		AdminId = adminId;
		AdminName = adminName;
	}
	//Admin with no fields
	public Admin() {
		
	}
	//Getters and Setters
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	//to String
	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", AdminName=" + AdminName + "]";
	}
	
}