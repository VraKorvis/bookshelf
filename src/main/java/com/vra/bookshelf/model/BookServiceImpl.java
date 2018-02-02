package com.vra.bookshelf.model;

import com.vra.bookshelf.dao.BookDao;
import com.vra.bookshelf.entity.BookshelfEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookDao bookDao;

    // 10 страниц, в зависимости от pid-(Page id)
    public List<BookshelfEntity> getListBookByPid(int pid) {
        return bookDao.getListBookByPid(pid);
    }

    //весь список
    public List<BookshelfEntity> getListBook() {
        return bookDao.getListBook();
    }

    public int getCountOfPages() {
        return (int)(Math.ceil(bookDao.getCountOfRecords()/10));
    }

    public void changeReadAlready(Integer id) {
        bookDao.toDoIsRead(id);
    }

    public List<BookshelfEntity> findBook(List<String> search) {
        return bookDao.findBook(search);
    }

    public void addBook(BookshelfEntity book) {
        if (book.getId()==0){
            bookDao.addBook(book);
        }else
            bookDao.updateBook(book);
    }

    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    public void updateBook(BookshelfEntity book) {
        bookDao.updateBook(book);
    }

    public BookshelfEntity getBookById(int id) {
        return bookDao.getBookById(id);
    }



}
