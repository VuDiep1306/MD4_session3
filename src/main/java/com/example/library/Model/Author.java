package com.example.library.Model;

public class Author {
    private Integer id;
    private String name;
    private String email;

    //constructor ko tham so
    public Author() {
    }

    //constructor co tham so
    public Author(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //getter setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
