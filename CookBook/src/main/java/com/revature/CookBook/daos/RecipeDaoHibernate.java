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

import com.revature.CookBook.pojos.Recipe;

@Repository(value = "recipeDao")
public class RecipeDaoHibernate implements RecipeDao{
	
	SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Recipe readRecipe(int recipeId) throws HibernateException {
		Recipe recipe = null;
		Session session = sessionFactory.openSession();
//		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
//		CriteriaQuery<Recipe> cQuery = cBuilder.createQuery(Recipe.class);
//		Root<Recipe> root = cQuery.from(Recipe.class);
//		cQuery.select(root).where(cBuilder.equal(root.get("id"), recipeId));
//		TypedQuery<Recipe> typedQuery = session.createQuery(cQuery);
//		recipe = typedQuery.getResultList().get(0);
		recipe = session.get(Recipe.class, recipeId);
		session.close();
		return recipe;
	}
	
	@Override
	public void createRecipe(Recipe recipe) throws HibernateException{
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(recipe);
		tx.commit();
		sess.close();
		//return recipe;
	}

	@Override
	public List<Recipe> readAllRecipes() throws HibernateException{
		List<Recipe> recipeList = null;
		Session sess = sessionFactory.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);
		Root<Recipe> rootEntry = cq.from(Recipe.class);
		CriteriaQuery<Recipe> all = cq.select(rootEntry);
		TypedQuery<Recipe> allQuery = sess.createQuery(all);
		recipeList = allQuery.getResultList();
		sess.close();
		return recipeList;
	}

	@Override
//	public Recipe updateRecipe(int recipeId, Recipe recipe) {
	public void updateRecipe(Recipe recipe) throws HibernateException {
    Session sess=sessionFactory.openSession();
		
		Transaction tx= sess.beginTransaction();
		sess.update(recipe);
		tx.commit();
		sess.close();
		
	}

	@Override
	public void deleteRecipe(int recipeId) throws HibernateException {
        
		Recipe recipe = new Recipe();
		recipe.setRecipeId(recipeId);
		Session sess=sessionFactory.openSession();
		Transaction tx= sess.beginTransaction();
		sess.delete(recipe);
		tx.commit();
		sess.close();
		
	}


}
