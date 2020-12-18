package com.revature.CookBook.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.revature.CookBook.pojos.User;

@Repository(value = "userDao")
public class UserDaoHibernate implements UserDao {

	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User readUser(String username) throws HibernateException {
		
		User user = null;
		Session session = sessionFactory.openSession();
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = cBuilder.createQuery(User.class);
		Root<User> root = cQuery.from(User.class);
		cQuery.select(root).where(cBuilder.equal(root.get("username"), username));
		TypedQuery<User> typedQuery = session.createQuery(cQuery);
		user = typedQuery.getResultList().get(0);
		session.close();
		return user;
	}

	@Override
	public void createUser(User user) throws HibernateException {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Override
	public void updateUser(User user) throws HibernateException {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteUser(int id) throws HibernateException {
		
		User user = new User();
		user.setUserId(id);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}

}
