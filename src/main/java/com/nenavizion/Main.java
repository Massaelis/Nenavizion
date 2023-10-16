package com.nenavizion;

import com.nenavizion.config.FlywayUtil;
import com.nenavizion.config.HibernateFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        FlywayUtil.initMigration();
        final Session session = sessionFactory.openSession();
        session.close();
    }
}
