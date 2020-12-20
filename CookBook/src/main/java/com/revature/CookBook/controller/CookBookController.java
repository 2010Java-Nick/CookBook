package com.revature.CookBook.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.revature.CookBook.dto.CookBookDto;
import com.revature.CookBook.pojos.CookBook;
import com.revature.CookBook.service.CookBookService;

@RestController
public class CookBookController {

	CookBookService cookBookService;

	
	@Autowired
	public void setCookBookService(CookBookService cookBookService) {
		this.cookBookService = cookBookService;
	}
	
    //will need to call suer service to make a user for author
	//Create recipe
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("cookbook")
	public void createCookBook(@RequestBody CookBookDto cookBookDto) {
		
		CookBook cookBook = cookBookDto.toPojo();
		//User user = userService.readUser(cookBookDto.getAuthor());
		//cookBook.setUser(user);
		boolean result = cookBookService.createCookBook(cookBook);
		ResponseEntity<CookBookDto> re = new ResponseEntity<CookBookDto>(HttpStatus.CREATED);
	}

	@RequestMapping(path = "cookbook/{cookbookId}", method = RequestMethod.GET)
	public CookBookDto readCookBook(@PathVariable(name = "cookbookId") int cookBookId) {
		CookBook cookBook = cookBookService.readCookBook(cookBookId);
		ResponseEntity<CookBookDto> re = new ResponseEntity<CookBookDto>(HttpStatus.OK);
		CookBookDto cookBookDto = new CookBookDto(cookBook);
		return cookBookDto;
	}
	
	@RequestMapping(path = "cookbook", method = RequestMethod.GET)
	public List<CookBookDto> readCookBook() {
		List <CookBookDto> cookBookDtoList=new ArrayList<>();
		List <CookBook> cookBookList = cookBookService.getAllCookBooks();
		for ( CookBook cookBook: cookBookList ) {
			cookBookDtoList.add( new CookBookDto(cookBook));
		}
		return cookBookDtoList;
	}
	
}
