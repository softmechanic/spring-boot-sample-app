package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {

}
