package com.vra.bookshelf.config;

import com.vra.bookshelf.dao.BookDao;
import com.vra.bookshelf.dao.BookDaoImpl;
import com.vra.bookshelf.model.BookService;
import com.vra.bookshelf.model.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.vra.bookshelf.model", "com.vra.bookshelf.dao"})
public class SpringConfig {

    // здесь будут описаны bean (вместо mvc-dispatcher-servelet.xml)
    // (inversion control)

    // wihtout hibernate use next (or mvc-dispatcher-servelet.xml)
//    @Bean
//    public DataSource getDataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/bookshelf?useSll=false");
//        dataSource.setUsename(root);
//        dataSource.setPassword("qwas");
//        dataSource.setDriverCLassName("com.mysql.jdbc.Driver");
//        return dataSource;
//    }

//    @Bean
//    public BookDao getBookDao(){
//        return new BookDaoImpl();
//    }
//    @Bean
//    public BookService getBookService(){
//        return new BookServiceImpl();
//    }

}
