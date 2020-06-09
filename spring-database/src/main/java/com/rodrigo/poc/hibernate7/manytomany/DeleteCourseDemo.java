package com.rodrigo.poc.hibernate7.manytomany;

import com.rodrigo.poc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate5.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            int courseID = 10;
            Course course = session.get(Course.class, courseID);
            System.out.println("Deleting course: " + course);
            session.delete(course );

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
