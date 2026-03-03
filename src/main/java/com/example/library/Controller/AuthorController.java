package com.example.library.Controller;

import com.example.library.Model.Author;
import com.example.library.Service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

        // getall
    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

        //create
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

        //get by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable("id") int id) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Khong tim thay tac gia voi ID la: " + id);
        }
        return ResponseEntity.ok(author);
    }


        //Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(
            @PathVariable("id") int id,
            @RequestBody Author request) {
        Author updatedAuthor = authorService.updateAuthor(id, request);
        if (updatedAuthor == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Khong tim thay tac gia voi ID la: " + id);
        }
        return ResponseEntity.ok(updatedAuthor);
    }

        //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Khong tim thay tac gia voi ID la: "+ id);
        }
        if (author.getName() != null &&
            author.getName().equalsIgnoreCase("Admin")) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Khong the xoa Admin");
        }
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Xoa thanh cong");
    }

        // Search
    @GetMapping("/search")
    public List<Author> searchAuthors (
            @RequestParam("name") String keyword ) {
        return authorService.searchAuthors(keyword);
    }
}
