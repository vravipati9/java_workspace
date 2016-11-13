package com.javaworld.email;

import java.util.Date;

public class EmailForm{
	private String emailId;
	private String emailTo;
	private String emailSubject;
	private String emailBody;
	private Date emailDate;
	
	public EmailForm(){}
	
	public EmailForm(String emailId, String emailTo, String emailSubject, String emailBody,
			Date emailDate) {
		super();
		this.emailId = emailId;
		this.emailTo = emailTo;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
		this.emailDate = emailDate;
	}
	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	public Date getEmailDate() {
		return emailDate;
	}
	public void setEmailDate(Date emailDate) {
		this.emailDate = emailDate;
	}
	
	public String toString() {
		StringBuffer emailFormStr = new StringBuffer("EmailForm=[ Email To= "+ emailTo);
		emailFormStr.append(", Email Id= " + emailId);
		emailFormStr.append(", Email Subject= " + emailSubject);
		emailFormStr.append(", Email Body= " + emailBody);
		emailFormStr.append(", Email Date= " + emailDate+"]");
		return emailFormStr.toString();
	}
	
	
	
}

