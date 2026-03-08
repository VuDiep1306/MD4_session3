package com.example.library.Controller;


import com.example.library.Dto.BorrowResponseDTO;
import com.example.library.Service.BorrowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BorrowController {
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("/borrow/{bookId}")
    public BorrowResponseDTO borrowBook(
            @PathVariable Long bookId,
            @RequestParam String studentName
    ) {
        return borrowService.borrowBook(bookId, studentName);
    }
}
