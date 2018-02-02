package com.vra.bookshelf.model;

import com.vra.bookshelf.entity.BookshelfEntity;

import java.util.List;

public interface BookService {
    void addBook(BookshelfEntity book);
    void deleteBook(int id);
    void updateBook(BookshelfEntity book);
    BookshelfEntity getBookById(int id);

    //список постраничный
    List<BookshelfEntity> getListBookByPid(int pid);

    //весь список
    List<BookshelfEntity> getListBook();

    int getCountOfPages();

    void changeReadAlready(Integer id);

    List<BookshelfEntity> findBook(List<String> search);
}
