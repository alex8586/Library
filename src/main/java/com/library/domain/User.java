package com.library.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

public class User {

    private long id;

    @NotBlank(message = "Field name can't be empty")
    @Pattern(regexp = "[a-zA-Z]+", message = "Name should be writing with letters")
    private String name;

    @Min(value = 1, message = "The minimum age should be 1")
    private Integer age;

    private List<Book> bookList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bookList=" + bookList +
                '}';
    }
}
