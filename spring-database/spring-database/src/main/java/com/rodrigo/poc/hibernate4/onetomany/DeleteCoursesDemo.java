package com.rodrigo.poc.hibernate4.onetomany;

import com.rodrigo.poc.entity.Course;
import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCoursesDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            int idCourse = 13;
            Course  course = session.get(Course.class, idCourse);
            session.delete(course);

            session.getTransaction().commit();
            System.out.println("Deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
