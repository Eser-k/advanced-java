package app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Book;

@RestController
public class BookController {

	@GetMapping("/books")
	public Book books() {
		var book = new Book("Charles Darwin", "Evolution");
		return book;
	}
	
	@RequestMapping(value = "/books",
	method = {RequestMethod.POST})
	public Book createBook(@RequestBody Book book) {
		
		System.out.println("Creating: " + book);
		book.setId(7L);
		return book;
	}
}
