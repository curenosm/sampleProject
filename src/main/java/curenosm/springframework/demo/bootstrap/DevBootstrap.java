package curenosm.springframework.demo.bootstrap;

import curenosm.springframework.demo.model.Author;
import curenosm.springframework.demo.model.Book;
import curenosm.springframework.demo.model.Publisher;
import curenosm.springframework.demo.repository.AuthorRepository;
import curenosm.springframework.demo.repository.BookRepository;
import curenosm.springframework.demo.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher harperCollins = new Publisher();
        harperCollins.setName("Harper Collins");
        harperCollins.setAddress("A normal address");

        Publisher worx = new Publisher();
        worx.setName("Worx");
        worx.setAddress("A normal address");

        publisherRepository.save(harperCollins);
        publisherRepository.save(worx);

        // Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks();
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Without EJB", "2334", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
