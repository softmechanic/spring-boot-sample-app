package com.example.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.BookEntity;
import com.example.entities.ResponseObject;
import com.example.services.BookServices;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookServices bookServices;

	@GetMapping(value = "/get-books-detail")
	public ResponseEntity<Object> getAllBooks() {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setListObj(bookServices.getAllBooks());
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}

	@GetMapping(value = "/get-book-details/{bookId}")
	public ResponseEntity<Object> getAllBooks(@PathVariable(value = "bookId") Integer bookId) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setListObj(Arrays.asList(bookServices.getBookDetails(bookId)));
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}

	@PostMapping(value = "/add-book-details")
	public ResponseEntity<Object> addBookDetails(@RequestBody BookEntity bookEntity) {
		ResponseObject responseObject = new ResponseObject();
		if (bookServices.addBookDetails(bookEntity)) {
			responseObject.setStatusCode("001");
			responseObject.setStatusMessage("Success");
		}
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}

	@PutMapping(value = "/modify-book-details")
	public ResponseEntity<Object> updateBookDetails(@RequestBody BookEntity bookEntity) {
		ResponseObject responseObject = new ResponseObject();
		if (bookServices.modifyBookDetails(bookEntity)) {
			responseObject.setStatusCode("001");
			responseObject.setStatusMessage("Success");
		}
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-book-details/{bookId}")
	public ResponseEntity<ResponseObject> removeBookDetails(@PathVariable(value = "bookId") Integer bookId) {
		ResponseObject responseObject = new ResponseObject();
		if (bookServices.removeBookDetails(bookId)) {
			responseObject.setStatusCode("001");
			responseObject.setStatusMessage("Success");
		}
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}
}
