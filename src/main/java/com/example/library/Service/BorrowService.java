package com.example.library.Service;

import com.example.library.Dto.BorrowResponseDTO;
import com.example.library.Model.Book;
import com.example.library.Model.BorrowTicket;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.BorrowTicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;

@Service
public class BorrowService {

    private final BookRepository bookRepository;
    private final BorrowTicketRepository borrowTicketRepository;

    public BorrowService(BookRepository bookRepository, BorrowTicketRepository borrowTicketRepository) {
        this.bookRepository = bookRepository;
        this.borrowTicketRepository = borrowTicketRepository;
    }

    @Transactional
    public BorrowResponseDTO borrowBook(Long bookId, String studentName) {

        // 1 kiểm tra sách tồn tại
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // 2 kiểm tra sách đang bị mượn
        borrowTicketRepository
                .findByBookIdAndStatus(bookId, "BORROWED")
                .ifPresent(ticket -> {
                    throw new RuntimeException("Book is already borrowed");
                });

        // 3 tạo phiếu mượn
        BorrowTicket ticket = new BorrowTicket();

        ticket.setStudentName(studentName);
        ticket.setBorrowDate(LocalDate.now());
        ticket.setStatus("BORROWED");
        ticket.setBook(book);

        borrowTicketRepository.save(ticket);

        // 4 trả DTO
        return new BorrowResponseDTO(
                studentName,
                book.getTitle(),
                book.getAuthor().getName(),
                ticket.getBorrowDate()
        );
    }
}
