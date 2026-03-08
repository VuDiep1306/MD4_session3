package com.example.library.Controller;

import com.example.library.Model.Author;
import com.example.library.Service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // GET all
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // GET by id
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    // POST
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    // PUT
    @PutMapping("/{id}")
    public Author updateAuthor(
            @PathVariable Long id,
            @RequestBody Author author) {

        return authorService.updateAuthor(id, author);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public boolean deleteAuthor(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }

    // SEARCH
    @GetMapping("/search")
    public List<Author> searchAuthors(
            @RequestParam String keyword) {

        return authorService.searchAuthors(keyword);
    }
}