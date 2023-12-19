package com.mav.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.mav.entity.RegisterEntity;

@Component
public class RegisterDaoImpl implements RegisterInterfaceDao{

	private SessionFactory sessionfactory;
	private JavaMailSenderImpl mailSender;
	
	public RegisterDaoImpl() {
		System.out.println("Default constructor of RegisterDao");
	}
	
	@Autowired
	public RegisterDaoImpl(SessionFactory sessionfactory, JavaMailSenderImpl mailSender) {
		super();
		this.sessionfactory = sessionfactory;
		this.mailSender = mailSender;
	}

	@Override
	public boolean saveRegisterDetails(RegisterEntity entity) {
		System.out.println("Invoked into saveRegisterDetails()");
		Session session = null;
		Transaction transaction = null;
		String subject = "Form Registration";
		String body = "*****<-- we are successfully done the registration process_ #Thank you -->*****";
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			Serializable save = session.save(entity);
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(entity.getEmail());
			mailMessage.setSubject(subject);
			mailMessage.setText(body);
			mailSender.send(mailMessage);
			System.out.println("Mail was sent succesfully");
			
			transaction.commit();
			System.out.println("saved the entity"+save);
			return true;
		}
		catch (Exception e) {
			transaction.rollback();
			System.out.println("Transaction rollback"+e.getMessage());
			return false;
		}
		finally {
			if(session != null)
			{
				session.close();
				System.out.println("session closed");
			}
		}
	}
	
}
