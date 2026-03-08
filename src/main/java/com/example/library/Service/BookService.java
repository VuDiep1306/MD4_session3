package com.example.library.Service;

import com.example.library.Dto.BookRequest;
import com.example.library.Model.Author;
import com.example.library.Model.Book;
import com.example.library.Repository.AuthorRepository;
import com.example.library.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // lay tat ca danh sach
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // lay sach theo id
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // them sach
    public Book createBook(BookRequest request) {
        Optional<Author> authorOptional = authorRepository.findById(request.getAuthorId());
        if (authorOptional.isEmpty()) {
            return null;
        }
        Author author = authorOptional.get();
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setPrice(request.getPrice());
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    // tìm sách theo tiêu đề
    public List<Book> searchByTitle(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }

    // sách có giá cao hơn trung bình
    public List<Book> findBooksAboveAveragePrice() {
        return bookRepository.findBooksAboveAveragePrice();
    }

    // thống kê sách theo tác giả
    public List<Objects[]> countBooksByAuthor() {
        return bookRepository.countBooksByAuthor();
    }
}
