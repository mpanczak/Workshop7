package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.simple.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService {
    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> reciveAllBooksList() {
        return list;
    }
    public Book searchBookById(long id) {
        for (Book book : list) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    public void createBook(Book book) {
        list.add(book);
    }
    public Book editBook(long id) {
//        for (Book book : list) {
//            if(book.getId() == id) {
//                list.remove(book);
//            }
//        }
        return null; //TODO
    }
    public void deleteBook(long id) {
        list.removeIf(book -> book.getId() == id);
    }
}
