package com.rodrigo.poc.hibernate4.onetomany;

import com.rodrigo.poc.entity.Course;
import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            int id = 1;
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("instructor: " + instructor);
            System.out.println("courses: " + instructor.getCourses());

            session.getTransaction().commit();
            System.out.println("Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
