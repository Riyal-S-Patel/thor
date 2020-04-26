package com.xworkz.cm.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.cm.dto.LoginDTO;
import com.xworkz.cm.entity.RegisterEntity;

@Component
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl() {
		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity getEmailAndPassword(LoginDTO loginDTO) {
		System.out.println("invoking getEmailAndPassword()...");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String email = loginDTO.getEmail();
			String password = loginDTO.getPassword();
			String hql = "from RegisterEntity where email='" + email + "' and password='" + password + "'";
			Query query = session.createQuery(hql);
			RegisterEntity registerEntity = (RegisterEntity) query.uniqueResult();
			System.out.println("entity : \t " + registerEntity);
			if (registerEntity != null) {
				System.out.println("Email and Password are correct");
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

	public void updateCountByEmail(int count, String email) {
		System.out.println("invoking updateCountByEmail()...");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String hql = "update RegisterEntity r set r.count=:count where r.email=:email";
			Query query = session.createQuery(hql);
			query.setParameter("count", count);
			query.setParameter("email", email);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
	}
}
