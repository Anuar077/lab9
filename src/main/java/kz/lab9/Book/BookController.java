package kz.lab9.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository BookRepository;

    @GetMapping
    List< Book> getBooks() {
        return BookRepository.findAll();
    }

    @PostMapping
    Book createBook(@RequestBody  Book book) {
        return BookRepository.save(book);
    }
}