package com.rodrigo.poc.hibernate;

import com.rodrigo.poc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudentDemo2 {

    public static void main(String... args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            System.out.println("Reading student object");
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
            System.out.println("Students retrieved: ");
            students.forEach(System.out::println);
            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }
}
