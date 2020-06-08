package com.rodrigo.poc.hibernate;

import com.rodrigo.poc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String... args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object");
            Student student = new Student("Alicia", "Ornelas", "zandy@palo-it.com");
            student.setId(1);
            session.beginTransaction();
            System.out.println("Saving student");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Saved");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
