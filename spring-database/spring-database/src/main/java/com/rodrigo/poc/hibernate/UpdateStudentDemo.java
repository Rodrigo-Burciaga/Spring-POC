package com.rodrigo.poc.hibernate;

import com.rodrigo.poc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            int id = 2;
            session.beginTransaction();
            System.out.println("Update student object with id: " + id);
            Student student = session.get(Student.class, id);
            System.out.println("Student retrieved: ");
            System.out.println(student);
            System.out.println("Updating ...");
            student.setEmail("nuevocorreo@gmail.com");
            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
