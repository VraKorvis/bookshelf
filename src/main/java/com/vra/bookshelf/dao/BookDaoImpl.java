package com.vra.bookshelf.dao;

import com.vra.bookshelf.entity.BookshelfEntity;
import com.vra.bookshelf.utils.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


@Repository
public class BookDaoImpl implements BookDao {

    //
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @SuppressWarnings("unchecked")
    public List<BookshelfEntity> getListBook() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<BookshelfEntity> list = session.createQuery("FROM BookshelfEntity").list();
        return list;
    }

    //ВАЖНО!!! "Do not use the session-per-operation antipattern:
    // do not open and close a Session for every simple database call in a single thread. "

    @SuppressWarnings("unchecked")
    public List<BookshelfEntity> getListBookByPid(int pid) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        int firstResult = (pid - 1) * 10;
        List<BookshelfEntity> list = session.createQuery("FROM BookshelfEntity")
                .setFirstResult(firstResult)
                .setMaxResults(10).list();

        for (int i = 0; i < list.size(); i++) {
            logger.info(list.get(i).getId() + " " + list.get(i).getTitle() + " " + list.get(i).getDescription()
                    + " " + list.get(i).getAuthor() + " " + list.get(i).getIsbn() + " " + list.get(i).getYear() + " "
                    + list.get(i).getReadAlready());
        }
        return list;
    }

    public int getCountOfRecords() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        // deprecated способ
//        Object countOrRecords = session.createCriteria(BookshelfEntity.class)
//                .setProjection(Projections.rowCount()).uniqueResult();
        // непонятно как работающий способ
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        query.select(builder.count(query.from(BookshelfEntity.class)));
        Long count = session.createQuery(query).getSingleResult();
        logger.info("Count of records in the DataBases " + count.intValue());
        return count.intValue();
    }

    // возможно неправильный способ!!!см. update
    public void addBook(BookshelfEntity book) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        Integer bookID = null;
        bookID = (Integer) session.save(book);

        tx = session.beginTransaction();
        session.flush();
        tx.commit();
        logger.info("Book was successfully added: " + book);
    }

    public void updateBook(BookshelfEntity book) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        Transaction tx = null;
        BookshelfEntity bk = (BookshelfEntity) session.load(BookshelfEntity.class, book.getId());

        bk.setId(book.getId());
        bk.setTitle(book.getTitle());
        bk.setDescription(book.getDescription());
        bk.setYear(book.getYear());
        bk.setReadAlready(false);
        bk.setIsbn(book.getIsbn());

        //session.update(book); // не требуется вероятно
        tx = session.beginTransaction();
        session.flush();
        tx.commit();

        logger.info("Book was successfully updated: " + book);
    }

    // сделать прочитанной
    public void toDoIsRead(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        Transaction tx = null;
        BookshelfEntity bk = (BookshelfEntity) session.load(BookshelfEntity.class, id);

        bk.setReadAlready(true);

        //session.update(book); // не требуется вероятно
        tx = session.beginTransaction();
        session.flush();
        tx.commit();

        logger.info("Successfull updated readyAlready: " + bk);
    }

    @SuppressWarnings("unchecked")
    public List<BookshelfEntity> findBook(List<String> search) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        final String text = search.get(0);
        final String isRead = search.get(1);
        final int after = Integer.parseInt(search.get(2));
        final int before = Integer.parseInt(search.get(3));

        StringBuilder hql = new StringBuilder("FROM BookshelfEntity where year between :after and :before ");

        // Query wqq = session.createQuery("FROM BookshelfEntity where year between :after and :before and readAlready=:tr and title=:text");
        boolean isR;
        if (!isRead.equals("e")) {
            isR = Boolean.valueOf(isRead);
            if (text.equals("")) {
                hql.append("and readAlready=:isR");
            } else {
                hql.append("and readAlready=:isR and title=:text");
            }
        } else {
            if (!text.equals("")) {
                hql.append("and title=:text");
            }
        }

        Query query = session.createQuery(hql.toString());
        query.setParameter("before", before);
        query.setParameter("after", after);

        if (!text.equals("")){
            query.setParameter("text", text);
        }
        if (!isRead.equals("e")){
            isR = Boolean.valueOf(isRead);
            query.setParameter("isR", isR);
        }

        List<BookshelfEntity> list = query.getResultList();

        for (int i = 0; i < list.size(); i++) {
            logger.info(list.get(i).getId() + " " + list.get(i).getTitle() + " " + list.get(i).getDescription()
                    + " " + list.get(i).getAuthor() + " " + list.get(i).getIsbn() + " " + list.get(i).getYear() + " "
                    + list.get(i).getReadAlready());
        }
        return list;
    }

    public void deleteBook(int id) {
        Transaction tx = null;
        BookshelfEntity book = null;
        try {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            book = (BookshelfEntity) session.load(BookshelfEntity.class, id);
            if (book != null) {
                session.remove(book);
                tx = session.beginTransaction();
                session.flush();
                tx.commit();
            }
        } catch (HibernateException hibEx) {
            if (tx != null) {
                tx.rollback();
            }
        }
        logger.info("Book was successfully removed: " + book);
    }

    public BookshelfEntity getBookById(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        BookshelfEntity book = (BookshelfEntity) session.load(BookshelfEntity.class, id);
        if (null != book) {
            logger.info("Information loaded book: " + book);
        } else logger.info("Information loaded book: " + "book not finded!");
        return book;
    }
}
