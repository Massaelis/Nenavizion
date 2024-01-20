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
         * - Довести до корректной компиляции проект
         * -- Написать скрипты на создание всех необходимых таблиц
         * -- Разбить один общий скрипт на N конкретных по типу
         * - Реализовать страницу продуктов (всех, по типу)
         * - Реализовать страницу просмотра конкретного продукта
         * - Почистить от "лишнего" html страницы
         * https://www.base64-image.de/
         * https://imgur.com/
         */
        SpringApplication.run(Main.class, args);
    }
}
