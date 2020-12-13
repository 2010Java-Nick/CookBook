package com.revature.CookBook.daos;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.CookBook.pojos.Recipe;
import com.revature.CookBook.pojos.User;

@Repository(value = "recipeDao")
public class RecipeDaoHibernate implements RecipeDao{
	
	SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Recipe readRecipe(int id) {
		Recipe recipe = null;
		Session session = sessionFactory.openSession();
		recipe = session.get(Recipe.class, id);
		session.close();
		return recipe;
	}
	
	@Override
	public Recipe createRecipe(Recipe recipe) {
		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(recipe);
		tx.commit();
		sess.close();
		return recipe;
	}

	@Override
	public List<Recipe> readAllRecipes() {
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
	public void updateRecipe(Recipe recipe) {
    Session sess=sessionFactory.openSession();
		
		Transaction tx= sess.beginTransaction();
		//Recipe recipe1 = sess.get(Recipe.class,recipeId);
		//get guest
		// change with setter 
		// sess.update()
		//merge? update
//		recipe1.setRecipeId(recipe.getRecipeId());
//		recipe1.setName(recipe.getName());
//		//recipe1.setAuthor(recipe.getAuthor());
//		//getFeatured?
//		recipe1.setFeatured(recipe.isFeatured());
//		recipe1.setServings(recipe.getServings());
//		recipe1.setPrepTime(recipe.getPrepTime());
//		recipe1.setCookTime(recipe.getCookTime());
//		recipe1.setSteps(recipe.getSteps());
//		recipe1.setTags(recipe.getTags());
//		recipe1.setIngredients(recipe.getIngredients());
//		recipe1.setDescription(recipe.getDescription());
		sess.update(recipe);
		tx.commit();
		sess.close();
		
		//return recipe1;
		
	}

	@Override
	public void deleteRecipe(int recipeId) {
        
		Recipe recipe = new Recipe();
		recipe.setRecipeId(recipeId);
		Session sess=sessionFactory.openSession();
		Transaction tx= sess.beginTransaction();
		sess.delete(recipe);
		tx.commit();
		sess.close();
		
	}


}
