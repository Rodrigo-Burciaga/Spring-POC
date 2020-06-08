package com.rodrigo.poc.hibernate7.manytomany;

import com.rodrigo.poc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetCoursesForUserDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate5.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int id = 5;
            Student student = session.get(Student.class, id);
            System.out.println("Student loaded: " + student);
            System.out.println("----------------courses: " + student.getCourses());

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
