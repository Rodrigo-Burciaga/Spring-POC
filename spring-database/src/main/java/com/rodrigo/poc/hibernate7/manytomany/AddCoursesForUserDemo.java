package com.rodrigo.poc.hibernate7.manytomany;

import com.rodrigo.poc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForUserDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate5.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int id = 2;
            Student student = session.get(Student.class, id);
            System.out.println("Student loaded: " + student);
            System.out.println("courses: " + student.getCourses());

            Course course = new Course("CS 101");
            Course course2 = new Course("Clean Code");

            course.addStudent(student);
            course2.addStudent(student);

            System.out.println("Saving the students");
            session.save(course);
            session.save(course2);


            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
