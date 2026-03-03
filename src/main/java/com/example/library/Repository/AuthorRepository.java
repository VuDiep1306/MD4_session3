package com.example.library.Repository;

import com.example.library.Model.Author;
import com.sun.source.tree.BreakTree;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
    private List<Author> authors = new ArrayList<>();

    public AuthorRepository() {
        authors.add(new Author(1, "Nguyen Van A", "a@gmail.com"));
        authors.add(new Author(2, "Tran Thi B", "b@gmail.com"));
        authors.add(new Author(3, "Le Van C", "c@gmail.com"));
    }

    //lấy danh sách thông tin các tác giả
    public List<Author> findAll() {
        return authors;
    }

    //Thêm mới Tác giả
    public void save(Author author) {
        authors.add(author);
    }

    //Truy vấn Tác giả theo ID
    public Author findById(int id) {
        for (Author author : authors) {
            if(author.getId() == id) {
                return author;
            }
        } return null;
    }

    //xoa
    public void delete(int id) {
        authors.removeIf(a -> a.getId() == id);
    }
}
