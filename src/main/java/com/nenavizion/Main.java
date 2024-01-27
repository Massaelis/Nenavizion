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
         * - Реализовать страницу продуктов (всех, по типу)
         * - Реализовать страницу просмотра конкретного продукта
         * - Почистить от "лишнего" html страницы
         * - Разобраться с пагинацией https://www.baeldung.com/spring-thymeleaf-pagination
         * - Разобраться с сортировкой https://www.bezkoder.com/thymeleaf-pagination-and-sorting-example/
         * - Разобраться с фильтрацией
         */
        SpringApplication.run(Main.class, args);
    }
}
