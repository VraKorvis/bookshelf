package com.vra.bookshelf.dao;

import com.vra.bookshelf.entity.BookshelfEntity;
import com.vra.bookshelf.utils.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
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

    //все записи, не использовал
    @SuppressWarnings("unchecked")
    public List<BookshelfEntity> getListBook() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return (List<BookshelfEntity>) session.createQuery("FROM BookshelfEntity").list();
    }

    //ВАЖНО!!! "Do not use the session-per-operation antipattern:
    // do not open and close a Session for every simple database call in a single thread. "

    //10 записей в зависимости от номера страницы (Page id)
    @SuppressWarnings("unchecked")
    public List<BookshelfEntity> getListBookByPid(int pid) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        int firstResult = (pid - 1) * 10;
        List<BookshelfEntity> list = session.createQuery("FROM BookshelfEntity")
                .setFirstResult(firstResult)
                .setMaxResults(10).list();

        for (BookshelfEntity aList : list) {
            logger.info(aList.getId() + " " + aList.getTitle() + " " + aList.getDescription()
                    + " " + aList.getAuthor() + " " + aList.getIsbn() + " " + aList.getYear() + " "
                    + aList.getReadAlready());
        }
        return list;
    }

    // всего записей в таблице
    public int getCountOfRecords() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
       // deprecated способ
       // Object countOrRecords = session.createCriteria(BookshelfEntity.class)
       //.setProjection(Projections.rowCount()).uniqueResult();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        query.select(builder.count(query.from(BookshelfEntity.class)));
        Long count = session.createQuery(query).getSingleResult();
        logger.info("Count of records in the DataBases " + count.intValue());
        return count.intValue();
    }

    //поиск по критериям
    @SuppressWarnings("unchecked")
    public List<BookshelfEntity> findBook(List<String> search) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        String text = search.get(0);
        String isRead = search.get(1);
        int after=0;
        int before=2500;

        try {
            after = Integer.parseInt(search.get(2));
            before = Integer.parseInt(search.get(3));
        }catch (NumberFormatException ignored){

        }
        StringBuilder hql = new StringBuilder("FROM BookshelfEntity where year between :after and :before ");

//        Query query = session.createQuery("FROM BookshelfEntity where year between :after and :before and title=:text or author=:text");

        if (!isRead.equals("e")){
            hql.append("and readAlready=:isR");
        }
        if (!text.equals("")){
            hql.append("and title like :text or author like :text");
        }
        Query query = session.createQuery(hql.toString());
        query.setParameter("before", before);
        query.setParameter("after", after);
        if (!text.equals("")){
            query.setParameter("text","%"+ text+"%");
        }
        if (!isRead.equals("e")){
           boolean isR = Boolean.valueOf(isRead);
            query.setParameter("isR", isR);
        }
//        int firstResult = (pid - 1) * 10;
//        query.setFirstResult(firstResult)
//                .setMaxResults(10);
        List<BookshelfEntity> list = query.getResultList();

        for (BookshelfEntity aList : list) {
            logger.info(aList.getId() + " " + aList.getTitle() + " " + aList.getDescription()
                    + " " + aList.getAuthor() + " " + aList.getIsbn() + " " + aList.getYear() + " "
                    + aList.getReadAlready());
        }
        return list;
    }

    // сделать прочитанной
    public void toDoIsRead(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        BookshelfEntity bk = session.load(BookshelfEntity.class, id);
        bk.setReadAlready(true);

        //session.update(book); // не требуется вероятно
        Transaction tx = session.beginTransaction();
        session.flush();
        tx.commit();

        logger.info("Successfull updated readyAlready: " + bk);
    }

    // возможно неправильный способ!!!см. update
    public void addBook(BookshelfEntity book) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        Integer bookID = (Integer) session.save(book);

        Transaction tx = session.beginTransaction();
        session.flush();
        tx.commit();
        logger.info("Book was successfully added: " + book);
    }

    public void updateBook(BookshelfEntity book) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        BookshelfEntity bk = session.load(BookshelfEntity.class, book.getId());
        bk.setId(book.getId());
        bk.setTitle(book.getTitle());
        bk.setDescription(book.getDescription());
        bk.setYear(book.getYear());
        bk.setReadAlready(false);
        bk.setIsbn(book.getIsbn());

        //session.update(book); // не требуется вероятно
        Transaction tx = session.beginTransaction();
        session.flush();
        tx.commit();

        logger.info("Book was successfully updated: " + book);
    }

    public void deleteBook(int id) {
        Transaction tx = null;
        BookshelfEntity book = null;
        try {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            book = session.load(BookshelfEntity.class, id);
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
        BookshelfEntity book = session.load(BookshelfEntity.class, id);
        if (null != book) {
            logger.info("Information loaded book: " + book);
        } else logger.info("Information loaded book: " + "book not finded!");
        return book;
    }
}
