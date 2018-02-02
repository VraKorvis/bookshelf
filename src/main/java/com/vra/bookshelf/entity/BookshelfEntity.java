package com.vra.bookshelf.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

//данный класс сущность бд
@Entity
@Table(name = "bookshelf", schema = "test")
public class BookshelfEntity {
    private int id;
    @Size(min = 2, max = 100, message = "Слишком короткое/длинное название")
    private String title;
    @Size(max = 255, message = "Превышен лимит символов")
    private String description;
    @Size(max = 100, message = "Слишком длинное имя")
    private String author;
    @Size(min = 8, max = 20, message = "Код ISBN должен быть от 8 до 20 цифр")
    private String isbn;
    private Integer year;
    private boolean readAlready;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Генерируемое значение
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 100)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "ISBN", nullable = true, length = 20)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "year", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "readAlready", nullable = true)
    public boolean getReadAlready() {
        return readAlready;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookshelfEntity that = (BookshelfEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookshelfEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", year=" + year +
                ", readAlready=" + readAlready +
                '}';
    }

}
