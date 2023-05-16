package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.MockBookService;
import pl.coderslab.simple.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MockBookService mockBookService = new MockBookService();

    @GetMapping("")
    public List<Book> acquireAllBooks() {
        return mockBookService.reciveAllBooksList();
    }
    @PostMapping("")
    public String createBook(@RequestBody Book book) {
        mockBookService.createBook(book);
        return "Book " + book.getId() + " created";
    }
    @GetMapping("/{id}")
    public Book acquireBook(@PathVariable("id") long id) {
        return mockBookService.searchBookById(id);
    }
    @PutMapping("")
    public String editBook(@RequestBody Book book) {
        mockBookService.editBook(book);
        return "Book " + book.getId() + " modified";
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        mockBookService.deleteBook(id);
        return "Book " + id + " deleted";
    }
}
