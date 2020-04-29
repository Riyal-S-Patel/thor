package com.xworkz.cm.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.cm.entity.RegisterEntity;

@Component
public class ForgotPasswordDAOImpl implements ForgotPasswordDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ForgotPasswordDAOImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity getByEmail(String email) {
		System.out.println("invoking getEmail()...");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String hql = "from RegisterEntity where email=:email";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			RegisterEntity registerEntity = (RegisterEntity) query.uniqueResult();
			System.out.println("entity : \t " + registerEntity);
			if (registerEntity != null) {
				System.out.println("Email is correct");
				return registerEntity;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}
	public int updatePassword(String password, int count, int id) {
		System.out.println("invoking updatePassword");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String hql = "update RegisterEntity r set r.password ='" + password + "', r.count='" + count
					+ "'where r.id='" + id + "'";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return 0;
	}

}
