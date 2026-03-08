package com.example.library.Repository;

import com.example.library.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
    public interface BookRepository extends JpaRepository<Book, Long>{

    //1. Query Method - Viết hàm tìm sách theo tiêu đề có chứa từ khóa (findByTitleContaining).
    List<Book> findByTitleContainingIgnoreCase(String keyword);

    // 2.@Query (JPQL): Viết truy vấn lấy tất cả sách có giá cao hơn mức trung bình.
    @Query("SELECT b FROM Book b WHERE b.price > (SELECT AVG(b2.price) FROM Book b2)")
    List<Book> findBooksAboveAveragePrice();

    //3.@Query (Native SQL): thống kê mỗi tác giả có bao nhiêu cuốn sách.
    @Query(value = """
            SELECT a.name, COUNT(b.id) AS total_books
            FROM author a
            LEFT JOIN book b ON a.id = b.author_id
            GROUP BY a.name
            """, nativeQuery = true)
    List<Objects[]> countBooksByAuthor();
}
