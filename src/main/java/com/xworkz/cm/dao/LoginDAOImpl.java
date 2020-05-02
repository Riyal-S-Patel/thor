package com.xworkz.cm.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
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

	private static final Logger logger = Logger.getLogger(LoginDAOImpl.class);

	public LoginDAOImpl() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public RegisterEntity getEmailAndPassword(LoginDTO loginDTO) {
		logger.info("invoking getEmailAndPassword()...");
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
				logger.info("Email and Password are correct");
				return registerEntity;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}

	public RegisterEntity getByEmail(String email) {
		logger.info("invoking getEmail()...");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String hql = "from RegisterEntity where email=:email";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			RegisterEntity registerEntity = (RegisterEntity) query.uniqueResult();
			logger.info("entity : \t " + registerEntity);
			if (registerEntity != null) {
				logger.info("Email is correct");
				return registerEntity;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
		return null;
	}

	public void updateCountByEmail(int count, String email) {
		logger.info("invoking updateCountByEmail()...");
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
			logger.error(e.getMessage(), e);
			session.getTransaction().rollback();
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
			}
		}
	}
}
