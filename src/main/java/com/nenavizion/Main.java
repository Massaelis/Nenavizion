package com.nenavizion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.nenavizion.repository")
@EntityScan("com.nenavizion.model")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        /**
         * - Разобраться с фильтрацией
         * -- Добавить фильтры*
         * -- Реализовать фильтр на основе данных с бекенда
         * -- Реализовать фильтр по нескольким критериям
         * -- Реализовать очистку фильтров
         * -- Реализовать фильтр в зависимости от типа товара на странице которого мы находимся
         *
         * TODO
         * - Разобраться с сортировкой https://www.bezkoder.com/thymeleaf-pagination-and-sorting-example/
         * - Разобраться с пагинацией https://www.baeldung.com/spring-thymeleaf-pagination
         */
        SpringApplication.run(Main.class, args);
    }
}
