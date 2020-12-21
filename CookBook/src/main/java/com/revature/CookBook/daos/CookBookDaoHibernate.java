package com.revature.CookBook.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.revature.CookBook.pojos.CookBook;
import com.revature.CookBook.pojos.Recipe;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "cookBookDao")
public class CookBookDaoHibernate implements CookBookDao {
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
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(cookBook);
		tx.commit();
		session.close();

	}

	@Override
	public List<CookBook> readAllCookBooks() throws HibernateException {
		List<CookBook> cookBookList = null;
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CookBook> cq = cb.createQuery(CookBook.class);
		Root<CookBook> rootEntry = cq.from(CookBook.class);
		CriteriaQuery<CookBook> all = cq.select(rootEntry);
		TypedQuery<CookBook> allQuery = session.createQuery(all);
		cookBookList = allQuery.getResultList();
		session.close();
		return cookBookList;
	}

	@Override
	public void updateCookBook(CookBook cookBook) throws HibernateException {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		session.update(cookBook);
		tx.commit();
		session.close();

	}

	@Override
	public void deleteCookBook(int cookBookId) throws HibernateException {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(cookBookId);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(recipe);
		tx.commit();
		session.close();

	}

}
