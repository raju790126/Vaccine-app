package com.mav.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.mav.entity.RegisterEntity;

@Component
public class LoginDaoImpl implements LoginInterfaceDao {
	
	private SessionFactory sessionfactory;
	private JavaMailSenderImpl mailSender;

	public LoginDaoImpl() {
		System.out.println("Default constructor of LoginDao()");
	}	
	
	@Autowired
	public LoginDaoImpl(SessionFactory sessionfactory, JavaMailSenderImpl mailSender) {
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
			
			Query query = session.createQuery("from RegisterEntity where email = :emailid", RegisterEntity.class);
			query.setParameter("emailid", emailid);
			Object result = query.getSingleResult();
			System.out.println("get the entity");
			return (RegisterEntity)result;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
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
	public void updateLoginAttempts(RegisterEntity entity) {

		System.out.println("Invoked into updateLoginAttempts()");
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			int i = entity.getLoginattempts();
			System.out.println(i);
			entity.setLoginattempts(i+1);
			session.update(entity);
			transaction.commit();
			
			System.out.println("Updated the attempts"+entity.getLoginattempts());
			System.out.println(entity);
				
		} catch (Exception e) {
			transaction.rollback();
			System.out.println(e.getMessage());
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
