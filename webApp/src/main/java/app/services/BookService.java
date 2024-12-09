package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repositories.BookDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.entities.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public List<Book> getAll(){
		
		List<Book> books = new ArrayList<>();
		bookDao.findAll().forEach(b -> books.add(b));
		
		return books;
	}
	
	public Book getBook(Long id) {
		Optional<Book> bookOpt = bookDao.findById(id);
		
		if(bookOpt.isPresent()) {
			return bookOpt.get();
		}
		
		return null;
	}
	
	public void save(Book book) {
		bookDao.save(book);
	}
}
