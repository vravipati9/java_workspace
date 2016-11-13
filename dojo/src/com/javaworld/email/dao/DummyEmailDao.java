package com.javaworld.email.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import com.javaworld.email.EmailForm;

public class DummyEmailDao implements EmailDao {
	private static HashMap emailMap = new HashMap();
	static {
		emailMap.put("1",new EmailForm("1","develpoer@javaworld.com","Sample Email","This is first test email",Calendar.getInstance().getTime()));
		emailMap.put("2",new EmailForm("2","manager@javaworld.com","First Test Email","This is first test email",Calendar.getInstance().getTime()));
		emailMap.put("3",new EmailForm("3","tester@javaworld.com","First Test Email","This is first test email",Calendar.getInstance().getTime()));
	}
	

	public ArrayList getInboxEmails() {
		ArrayList inboxEmailList = new ArrayList();
		Iterator emailIt =  emailMap.values().iterator();
		while(emailIt.hasNext()){
			inboxEmailList.add(emailIt.next());
		}
		return inboxEmailList;
	}

	public void sendEmail(EmailForm emailForm) {
		System.out.println("Sending email " + emailForm);
		
	}

	public EmailForm getEmail(String emailId) {
		return (EmailForm)emailMap.get(emailId);
	}

}
