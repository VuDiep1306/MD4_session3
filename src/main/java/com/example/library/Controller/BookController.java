package com.example.library.Controller;

import com.example.library.Dto.BookRequest;
import com.example.library.Model.Book;
import com.example.library.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Post books
    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest request) {
        Book book = bookService.createBook(request);
        if(book == null) {
            return ResponseEntity.badRequest().body("Tac gia khong ton tai");
        }
        return ResponseEntity.ok(book);
    }

    //Get books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //get books id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // tìm sách theo tiêu đề
    @GetMapping("/searchByTitle")
    public List<Book> searchByTitle(@RequestParam String keyword) {
        return bookService.searchByTitle(keyword);
    }

    // sách có giá cao hơn trung bình
    @GetMapping("/getBookHightPrice")
    public List<Book> findBooksAboveAveragePrice() {
        return bookService.findBooksAboveAveragePrice();
    }

    // thống kê số sách theo tác giả
    @GetMapping("/statisticsByAuthor")
    public List<Objects[]> countBooksByAuthor() {
        return bookService.countBooksByAuthor();
    }
}
