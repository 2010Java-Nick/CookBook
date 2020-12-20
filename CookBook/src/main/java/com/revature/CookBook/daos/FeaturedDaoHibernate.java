package com.revature.CookBook.daos;

import java.util.List;

import com.revature.CookBook.pojos.Featured;
import com.revature.CookBook.pojos.Recipe;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "featuredDao")
public class FeaturedDaoHibernate implements FeaturedDao {

	SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createFeatured(Featured featured) throws HibernateException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(featured);
		tx.commit();
		session.close();

	}

	@Override
	public List<Recipe> readPendingRecipes() throws HibernateException {

		Session session = sessionFactory.openSession();

		String hql = "select f.recipe from Featured f";

		Query<Recipe> query = session.createQuery(hql, Recipe.class);
		return query.list();

	}

	@Override
	public void deletePending(Recipe recipe) throws HibernateException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hql = "delete Featured f where :Recipe = f.recipe";

		javax.persistence.Query query = session.createQuery(hql);
		query.setParameter("Recipe", recipe);

		query.executeUpdate();

		tx.commit();
		session.close();
	}
}
