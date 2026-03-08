package com.example.library.Service;

import com.example.library.Model.Author;
import com.example.library.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    // Constructor Injection
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Lấy tất cả tác giả
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Tạo mới
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Tìm theo ID
    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    // Cập nhật
    public Author updateAuthor(Long id, Author request) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()) {
            Author existingAuthor = optionalAuthor.get();
            existingAuthor.setName(request.getName());
            existingAuthor.setEmail(request.getEmail());
            return authorRepository.save(existingAuthor);
        }

        return null;
    }

    // Xóa
    public boolean deleteAuthor(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isEmpty()) {
            return false;
        }

        Author author = optionalAuthor.get();

        if (author.getName() != null &&
                author.getName().equalsIgnoreCase("Admin")) {
            return false;
        }

        authorRepository.deleteById(id);
        return true;
    }

    // Tìm kiếm theo keyword
    public List<Author> searchAuthors(String keyword) {
        List<Author> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Author author : authorRepository.findAll()) {
            if (author.getName() != null &&
                    author.getName().toLowerCase().contains(lowerKeyword)) {
                result.add(author);
            }
        }

        return result;
    }
}
