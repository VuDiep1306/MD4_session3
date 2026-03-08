package com.example.library.Dto;

import java.time.LocalDate;

public class BorrowResponseDTO {
    private String studentName;
    private String bookTitle;
    private String author;
    private LocalDate borrowDate;

    public BorrowResponseDTO() {}

    public BorrowResponseDTO(String studentName, String bookTitle, String author, LocalDate borrowDate) {
        this.studentName = studentName;
        this.bookTitle = bookTitle;
        this.author = author;
        this.borrowDate = borrowDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
}


