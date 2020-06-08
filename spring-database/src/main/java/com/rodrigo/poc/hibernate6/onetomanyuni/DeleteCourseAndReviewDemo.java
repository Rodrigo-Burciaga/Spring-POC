package com.rodrigo.poc.hibernate6.onetomanyuni;

import com.rodrigo.poc.entity.Course;
import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import com.rodrigo.poc.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseAndReviewDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate4.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int id = 11;
            Course course = session.get(Course.class, id);
            System.out.println("-----------------deleting: " + course);
            System.out.println("-----------------" + course.getReviews());
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
