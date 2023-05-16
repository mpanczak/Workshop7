package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.MockBookService;
import pl.coderslab.simple.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    MockBookService mockBookService = new MockBookService();

//    @RequestMapping("/helloBook")
//    public Book helloBook() {
//        return new Book(1L, "9788324631766", "Thinking in Java",
//                "Bruce Eckel", "Helion", "programming");
//    }
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
    public Book editBook() {
        return null; //TODO
    }
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        mockBookService.deleteBook(id);
        return "Book " + id + " deleted";
    }
}
