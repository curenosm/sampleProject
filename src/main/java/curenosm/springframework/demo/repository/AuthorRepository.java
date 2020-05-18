package curenosm.springframework.demo.repository;

import curenosm.springframework.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
