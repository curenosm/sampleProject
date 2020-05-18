package curenosm.springframework.demo.repository;

import curenosm.springframework.demo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
