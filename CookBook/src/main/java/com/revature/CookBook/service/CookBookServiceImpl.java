package com.revature.CookBook.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.CookBook.daos.CookBookDao;
import com.revature.CookBook.pojos.CookBook;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookBookServiceImpl implements CookBookService {

	CookBookDao cookBookDao;

	@Autowired
	public void setCookBookDao(CookBookDao cookBookDao) {
		this.cookBookDao = cookBookDao;
	}

	@Override
	public CookBook readCookBook(int cookBookId) {
		CookBook cookBook = null;
		try {
			cookBook = cookBookDao.readCookBook(cookBookId);
		} catch (HibernateException e) {
		}

		return cookBook;
	}

	@Override
	public boolean createCookBook(CookBook cookBook) {
		try {
			cookBookDao.createCookBook(cookBook);
			return true;
		} catch (HibernateException e) {
		}
		return false;
	}

	@Override
	public List<CookBook> getAllCookBooks() {

		List<CookBook> cookBookList = new ArrayList<>();
		try {
			cookBookList = cookBookDao.readAllCookBooks();
		} catch (HibernateException e) {
		}

		return cookBookList;
	}

	@Override
	public boolean updateCookBook(CookBook cookBook) {
		try {
			cookBookDao.updateCookBook(cookBook);
			return true;
		} catch (HibernateException e) {
		}
		return false;
	}

	@Override
	public boolean deleteCookBook(int cookBookId) {
		try {
			cookBookDao.deleteCookBook(cookBookId);
			return true;
		} catch (HibernateException e) {
		}
		return false;
	}

}
