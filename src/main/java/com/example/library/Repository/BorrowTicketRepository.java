package com.example.library.Repository;

import com.example.library.Model.BorrowTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowTicketRepository extends JpaRepository<BorrowTicket, Long> {
    Optional<BorrowTicket> findByBookIdAndStatus(Long bookId, String status);

}
