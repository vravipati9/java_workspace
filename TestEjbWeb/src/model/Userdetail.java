package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userdetails database table.
 * 
 */
@Entity
@Table(name="userdetails")
public class Userdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	private String userName;
	
	private static int aadharId;
	
	
	
    public static int getAadharId() {
		return aadharId;
	}
    
    public void increment() {
    	this.userId++;
    	aadharId++;
    }
    
	public static void setAadharId(int aadharId) {
		Userdetail.aadharId = aadharId;
	}

	public Userdetail() {
    }

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}