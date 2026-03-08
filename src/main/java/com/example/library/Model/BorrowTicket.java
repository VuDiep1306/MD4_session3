package com.example.library.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BorrowTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    private LocalDate borrowDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowTicket() {}

    public BorrowTicket(Long id, String studentName, LocalDate borrowDate, String status, Book book) {
        this.id = id;
        this.studentName = studentName;
        this.borrowDate = borrowDate;
        this.status = status;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
