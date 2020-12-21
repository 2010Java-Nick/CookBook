package com.revature.CookBook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.revature.CookBook.dto.CookBookDto;
import com.revature.CookBook.pojos.CookBook;
import com.revature.CookBook.pojos.User;
import com.revature.CookBook.service.CookBookService;
import com.revature.CookBook.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookBookController {

	CookBookService cookBookService;
	UserService userService;

	@Autowired
	public void setCookBookService(CookBookService cookBookService) {
		this.cookBookService = cookBookService;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("cookbook")
	public void createCookBook(@RequestBody CookBookDto cookBookDto, HttpServletResponse response) {
		CookBook cookBook = cookBookDto.toPojo();
		User user = userService.readUser(cookBookDto.getAuthor());
		cookBook.setUser(user);

		if (cookBookService.createCookBook(cookBook)) {
			response.setStatus(201);
		} else {
			response.setStatus(400);
		}
	}

	@RequestMapping(path = "cookbook/{cookbookId}", method = RequestMethod.GET)
	public CookBookDto readCookBook(@PathVariable(name = "cookbookId") int cookBookId, HttpServletResponse response) {

		CookBook cookBook = cookBookService.readCookBook(cookBookId);
		CookBookDto cookBookDto = new CookBookDto(cookBook);

		if (cookBook != null) {
			response.setStatus(200);
		} else {
			response.setStatus(400);
		}
		return cookBookDto;
	}

	@RequestMapping(path = "cookbook", method = RequestMethod.GET)
	public List<CookBookDto> readCookBook(HttpServletResponse response) {

		List<CookBookDto> cookBookDtoList = new ArrayList<>();
		List<CookBook> cookBookList = cookBookService.getAllCookBooks();
		
		for (CookBook cookBook : cookBookList) {
			cookBookDtoList.add(new CookBookDto(cookBook));
		}
		if (cookBookDtoList.size() > 0) {
			response.setStatus(200);
		} else {
			response.setStatus(400);
		}
		return cookBookDtoList;
	}

}
