package com.revature.CookBook.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.CookBook.pojos.User;

@Repository(value = "userDao")
public class UserDaoHibernate implements UserDao {

	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User readUser(int id) {
		
		User user = null;
		Session session = sessionFactory.openSession();
		user = session.get(User.class, id);
		session.close();
		return user;
	}

	@Override
	public void createUser(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Override
	public void updateUser(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteUser(int id) {
		
		User user = new User();
		user.setUserId(id);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}

}
