package curenosm.springframework.demo.controller;

import curenosm.springframework.demo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        // Adding attributes (variables) to the model (context)
        model.addAttribute("books", bookRepository.findAll());

        // Returning name of Thymeleaf view (template)
        return "books";
    }

}
