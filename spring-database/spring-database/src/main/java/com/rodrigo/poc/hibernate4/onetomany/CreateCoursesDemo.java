package com.rodrigo.poc.hibernate4.onetomany;

import com.rodrigo.poc.entity.Course;
import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            int id = 1;
            session.beginTransaction();
            Instructor  instructor = session.get(Instructor.class, id);
            Course course1 = new Course("Docker");
            Course course2 = new Course("Java 8");
            instructor.addCourse(course1);
            instructor.addCourse(course2);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
            System.out.println("Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
