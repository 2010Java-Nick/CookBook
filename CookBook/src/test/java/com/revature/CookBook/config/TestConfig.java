package com.revature.CookBook.config;

import org.mockito.Mockito;

import com.revature.CookBook.daos.RecipeDao;
import com.revature.CookBook.service.RecipeService;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
public class TestConfig {
    @Bean
    public SessionFactory sessionFactory() {

        return Mockito.mock(SessionFactory.class);
    }


    @Bean
    public RecipeDao recipeDao() {

        return Mockito.mock(RecipeDao.class);
    }

    @Bean
    public RecipeService recipeService() {

        return Mockito.mock(RecipeService.class);
    }
}
