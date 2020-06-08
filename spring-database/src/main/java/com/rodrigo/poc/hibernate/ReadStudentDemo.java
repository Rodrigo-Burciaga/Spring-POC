package com.rodrigo.poc.hibernate;

import com.rodrigo.poc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String... args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            System.out.println("Reading student object");
            session.beginTransaction();
            Student student = session.get(Student.class, 2);
            System.out.println("Student retrieved: ");
            System.out.println(student);
            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }
}
