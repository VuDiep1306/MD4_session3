package com.example.library.Service;

import com.example.library.Model.Author;
import com.example.library.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    // Constructor Injection (Dependency Injection)
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

        // tao moi
    public Author createAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }
        // tim them id
    public Author getAuthorById(int id) {
        return authorRepository.findById(id);
    }

        // Capnhat
    public Author updateAuthor(int id, Author request) {
        Author existingAuthor = authorRepository.findById(id);
        if (existingAuthor != null) {
            existingAuthor.setName(request.getName());
            existingAuthor.setEmail(request.getEmail());
            return existingAuthor;
        }
        return null;
    }

        // Xoa
    public boolean deleteAuthor(int id) {
        Author author = authorRepository.findById(id);
        if (author == null) {
            return false;
        }
        if (author.getName() != null &&
            author.getName().equalsIgnoreCase("Admin")) {
            return false;
        }
        authorRepository.delete(id);
        return true;
    }

        // Tìm kiếm Tác giả theo từ khóa
    public List<Author> searchAuthors(String keyword) {
        List<Author> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        for (Author author : authorRepository.findAll()) {
            if(author.getName() != null &&
                author.getName().toLowerCase().contains(lowerKeyword)) {
                result.add(author);
            }
        }
        return result;
    }
}
