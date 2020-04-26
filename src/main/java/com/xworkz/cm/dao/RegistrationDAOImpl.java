package com.xworkz.cm.dao;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.cm.entity.RegisterEntity;
@Component
public class RegistrationDAOImpl implements RegistrationDAO {
	@Autowired
	private SessionFactory factory;

	public RegistrationDAOImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity getUserByUserId(String userId) {
		Session session = factory.openSession();
		try {
			Query query = session.createQuery("FROM RegisterEntity r WHERE r.userId=:userId");
			query.setParameter("userId", userId);
			RegisterEntity entity = (RegisterEntity) query.uniqueResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public RegisterEntity getUserByEmail(String email) {
		Session session = factory.openSession();
		try {
			Query query = session.createQuery("FROM RegisterEntity r WHERE r.email=:email");
			query.setParameter("email", email);
			RegisterEntity entity = (RegisterEntity) query.uniqueResult();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Serializable saveRegister(RegisterEntity registerEntity) {
		System.out.println("invoked saveRegister");
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Serializable result=session.save(registerEntity);
			session.getTransaction().commit();
			if (Objects.nonNull(registerEntity)) {
				System.out.println("data saved in database successfully..!!");
			} else {
				System.out.println("data not saved in database..!!");
			}
			return result;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session))
				session.close();
		}
		return null;
		
	}

}
