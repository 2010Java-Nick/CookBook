package com.revature.CookBook.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.CookBook.pojos.CookBook;
import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.WeeklyCookBook;


@Repository(value = "cookBookDao")
public class CookBookDaoHibernate implements CookBookDao{
	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public CookBook readCookBook(int cookBookId) throws HibernateException {
		CookBook cookBook = null;
		Session session = sessionFactory.openSession();
		cookBook = session.get(CookBook.class, cookBookId);
		session.close();
		return cookBook;

	}

	@Override
	public void createCookBook(CookBook cookBook) throws HibernateException {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(cookBook);
		tx.commit();
		sess.close();
		
	}

	@Override
	public List<CookBook> readAllCookBooks() throws HibernateException {
		List<CookBook> cookBookList = null;
		Session sess = sessionFactory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<CookBook> cq = cb.createQuery(CookBook.class);
		Root<CookBook> rootEntry = cq.from(CookBook.class);
		CriteriaQuery<CookBook> all = cq.select(rootEntry);
		TypedQuery<CookBook> allQuery = sess.createQuery(all);
		cookBookList = allQuery.getResultList();
		sess.close();
		return cookBookList;
	}

	@Override
	public void updateCookBook(CookBook cookBook) throws HibernateException {
	    Session sess=sessionFactory.openSession();
		
			Transaction tx= sess.beginTransaction();
			sess.update(cookBook);
			tx.commit();
			sess.close();
		
	}

	@Override
	public void deleteCookBook(int cookBookId) throws HibernateException {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(cookBookId);
		Session sess=sessionFactory.openSession();
		Transaction tx= sess.beginTransaction();
		sess.delete(recipe);
		tx.commit();
		sess.close();
		
		
	}

//	@Override
//	public WeeklyCookBook readWeeklyCookBook(int weeklyCookBookId) throws HibernateException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void createWeeklyweeklyCookBook(WeeklyCookBook weeklyCookBook) throws HibernateException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<WeeklyCookBook> readAllWeeklyCookBooks() throws HibernateException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateWeeklyCookBook(WeeklyCookBook weeklyCookBook) throws HibernateException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteWeeklyCookBook(int weeklyCookBookId) throws HibernateException {
//		// TODO Auto-generated method stub
//		
//	}

}
