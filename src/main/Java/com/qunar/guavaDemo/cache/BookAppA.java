package com.qunar.guavaDemo.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * author: 龚细军
 * class-aim:
 */
@Service
public class BookAppA {
    Book book = new Book();

    @Cacheable(value = "itDemo")
    public Book getBook() {
        //从某处去拿去数据
        System.out.println("it's the first time to visiting");
        book.setBookName("gongxijun");
        return book;
    }
}
