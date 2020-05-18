package curenosm.springframework.demo.repository;

import curenosm.springframework.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
