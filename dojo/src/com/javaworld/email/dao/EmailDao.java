package com.javaworld.email.dao;

import java.util.ArrayList;

import com.javaworld.email.EmailForm;

public interface EmailDao {

	public ArrayList getInboxEmails();
	
	public EmailForm getEmail(String emailId);
	
	public void sendEmail(EmailForm emailForm);
	
}
