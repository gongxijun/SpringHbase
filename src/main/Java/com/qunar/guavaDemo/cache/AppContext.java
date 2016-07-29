package com.qunar.guavaDemo.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * author: 龚细军
 * class-aim:
 */

@Configuration
public class AppContext {

    @Bean
    @Scope(value = "prototype")
    public Book initBook() {
        //从数据源中获取数据，然后
        Book book = new Book();
        book.setBookName("编译原理");
        return book;
    }
}
