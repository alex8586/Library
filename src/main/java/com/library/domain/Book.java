package com.library.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Book implements Comparable<Book> {

    private long id;

    @NotBlank(message = "Title can't be empty")
    @Size(min = 2, message = "Title must be longer than (min) letters")
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int compareTo(Book o) {
        return this.title.compareTo(o.getTitle());
    }
}
