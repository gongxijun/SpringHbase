/*
package com.qunar.guavaDemo.cache;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

*/
/**
 * author: 龚细军
 * class-aim:
 *//*

@Configuration
@ComponentScan("com.qunar.guavaDemo.cache")
@EnableCaching
public class AppConfigA {

    @Bean
    public CacheManager cacheManager() {

        GuavaCacheManager cacheManager1 = new GuavaCacheManager("itDemo");
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(100, TimeUnit.MINUTES);
        cacheManager1.setCacheBuilder(cacheBuilder);
        return cacheManager1;
    }

    @Bean
    public String name() {
        return "你好";
    }
}*/
