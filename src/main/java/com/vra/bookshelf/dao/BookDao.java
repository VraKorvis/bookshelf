package com.vra.bookshelf.dao;

import com.vra.bookshelf.entity.BookshelfEntity;

import java.util.List;

public interface BookDao {
    void addBook(BookshelfEntity book);
    void deleteBook(int id);
    void updateBook(BookshelfEntity book);
    BookshelfEntity getBookById(int id);
    List<BookshelfEntity> getListBookByPid(int pid);

    int getCountOfRecords();

    List<BookshelfEntity> getListBook();

    void toDoIsRead(Integer id);

    List<BookshelfEntity> findBook(List<String> search);

}
