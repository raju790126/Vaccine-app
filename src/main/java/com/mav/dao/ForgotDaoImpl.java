package com.mav.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.mav.entity.RegisterEntity;

@Component
public class ForgotDaoImpl implements ForgotInterfaceDao {
	
	private SessionFactory sessionfactory;
	private JavaMailSenderImpl mailSender;
	
	public ForgotDaoImpl() {
	System.out.println("Invoked into default ForgotDaoImpl() constructor");
	}
	
	@Autowired
	public ForgotDaoImpl(SessionFactory sessionfactory, JavaMailSenderImpl mailSender) {
		super();
		this.sessionfactory = sessionfactory;
		this.mailSender = mailSender;
	}
	
	@Override
	public RegisterEntity getEmailDetails(String emailid) {
		System.out.println("Invoked into getEmailDetails()");
		Session session = null;
		try {
			session = sessionfactory.openSession();
//			Query<RegisterEntity> query = session.createQuery("form RegisterEntity where email :uemail",RegisterEntity.class);
//			query.setParameter("uemail", uemail);
//			query.setParameter(uemail, query)
			Query query = session.createQuery("from RegisterEntity where email = :emailid", RegisterEntity.class);
			query.setParameter("emailid", emailid);
			Object result = query.getSingleResult();
			RegisterEntity entity = (RegisterEntity) query.getSingleResult();
			System.out.println("get the entity");
			return entity;
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			return null;
		}
		finally {
			if(session != null)
			{
				session.close();
				System.out.println("session closed");
			}
		}
		
	}

	@Override
	public boolean changePassword(RegisterEntity entity, String password) {

		System.out.println("Invoked into changePassword()");
		Session session = null;
		Transaction transaction = null;
		try
		{
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			entity.setPassword(password);
			entity.setLoginattempts(0);
			session.update(entity);
			transaction.commit();
			System.out.println("update the password");
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(entity.getEmail());
			message.setSubject("Alret Changed Password");
			message.setText("Successfully changed new password to your register account"
					+ "Your new password : "+ entity.getPassword());
			mailSender.send(message);
			System.out.println("Mail was sended");
			return true;
		}
		catch (Exception e) {
			transaction.rollback();
			System.out.println(e.getMessage());
			return false;
		}finally {
			if(session != null)
			{
				session.close();
				System.out.println("session closed");
			}
		}	
	}

}
