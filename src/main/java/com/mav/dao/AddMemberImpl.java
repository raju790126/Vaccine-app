package com.mav.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mav.entity.AddMemberEntity;
import com.mav.entity.RegisterEntity;

@Component
public class AddMemberImpl implements AddMemberInterface {
	
	private SessionFactory sessionfactory;
	
	public AddMemberImpl() {
		System.out.println("Default constructor of AddMemberImpl()");
	}
	
	@Autowired
	public AddMemberImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	@Override
	public boolean saveAddMember(AddMemberEntity addentity) {

		System.out.println("Invoked into the saveAddMember() controller");
		Session session = null;
		try {
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(addentity);
			transaction.commit();
			System.out.println("saved the add entity");
			return true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
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

	@Override
	public boolean updateRegisterMember(RegisterEntity regentity) {
		System.out.println("Invoked into the updateRegisterMember() controller");
		Session session = null;
		Transaction transaction =null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			regentity.setMembercount(regentity.getMembercount() +1);
			session.update(regentity);
			transaction.commit();
			System.out.println("increase the member count in Register entity");
			return true;
			
		} catch (Exception e) {
			transaction.rollback();
			System.out.println(e.getMessage());
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

	@Override
	public List<AddMemberEntity> setAllAddMembers(String addemail) {

		System.out.println("Invoked into the selectAllAddMembers() dao");
		System.out.println(addemail);
		Session session = null;
		List list = null;
		try {
			session = sessionfactory.openSession();
			Query<AddMemberEntity> query = session.createQuery("FROM AddMemberEntity m WHERE m.useremail = :addemail", AddMemberEntity.class);
//			Query query = session.createQuery("FROM AddMemberEntity WHERE useremail = :addemail");
			query.setParameter("addemail", addemail);
			
			  System.out.println("Generated SQL Query: " + query.getQueryString());
			
			list = query.getResultList();
			System.out.println("get the list");
			return list;
			
		} catch (Exception e) {

			e.printStackTrace();
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
	public AddMemberEntity getDetailsById(int id) {
		System.out.println("Invoked into the getDetailsById() dao");
		Session session = null;
		try {
			session = sessionfactory.openSession();
			AddMemberEntity entity = session.get(AddMemberEntity.class, id);
			System.out.println("get the entity");
			return entity;
			
		} catch (Exception e) {
			e.printStackTrace();
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
	public boolean updateMemberDetails(AddMemberEntity entity) {

		System.out.println("Invoked into updateMemberDetails DAO method");
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			transaction.rollback();
			return false;
		}
		finally {
			if(session != null)
			{
				session.close();
				System.out.println("session obj closed");
			}
		}
	}

	@Override
	public boolean deleteMemberDetails(int id) {
		System.out.println("invoked into deleteMemberDetails  by Id DAO method");
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			AddMemberEntity entity = session.get(AddMemberEntity.class, id);
			if(entity != null)
			{
				session.delete(entity);
				transaction.commit();
				System.out.println("Delete the member");
				return true;
			}
			else {
				return false;
			}
		}catch (Exception e) {
			transaction.rollback();
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			if(session != null)
			{
				session.close();
				System.out.println("session obj closed");
			}
		}
	}

	@Override
	public boolean decreaseCountRegisterMember(RegisterEntity regentity) {
		System.out.println("Invoked into the decreaseCountRegisterMember() controller");
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionfactory.openSession();
			transaction = session.beginTransaction();
			
			regentity.setMembercount(regentity.getMembercount() -1);
			session.update(regentity);
			transaction.commit();
			System.out.println("decrease the member count in Register entity");
			return true;
			
		} catch (Exception e) {
			transaction.rollback();
			System.out.println(e.getMessage());
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
