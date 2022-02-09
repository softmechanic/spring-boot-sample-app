package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.BookEntity;
import com.example.repositories.BookRepository;

@Service
public class BookServices {

	@Autowired
	private BookRepository bookRepository;

	public List<BookEntity> getAllBooks() {
		List<BookEntity> books = new ArrayList<>();
		bookRepository.findAll().forEach(bookDetail -> books.add(bookDetail));
		return books;
	}

	public BookEntity getBookDetails(Integer bookId) {
		if (bookRepository.findById(bookId).isPresent()) {
			return bookRepository.findById(bookId).get();
		}
		return null;
	}

	public Boolean addBookDetails(BookEntity bookEntity) {
		if (bookRepository.save(bookEntity) != null) {
			return true;
		}
		return false;
	}

	public Boolean modifyBookDetails(BookEntity bookEntity) {
		if (bookRepository.findById(bookEntity.getBookId()).isPresent()) {
			BookEntity persistedBookEntity = bookRepository.findById(bookEntity.getBookId()).get();
			BeanUtils.copyProperties(bookEntity, persistedBookEntity);
			bookRepository.save(persistedBookEntity);
			return true;
		}
		return false;
	}

	public Boolean removeBookDetails(Integer bookId) {
		if (bookRepository.findById(bookId).isPresent()) {
			BookEntity persistedBookEntity = bookRepository.findById(bookId).get();
			bookRepository.delete(persistedBookEntity);
			return true;
		}
		return false;
	}
}
