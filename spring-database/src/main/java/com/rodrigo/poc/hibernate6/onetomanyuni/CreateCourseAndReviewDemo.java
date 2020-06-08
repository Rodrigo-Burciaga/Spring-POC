package com.rodrigo.poc.hibernate6.onetomanyuni;

import com.rodrigo.poc.entity.Course;
import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import com.rodrigo.poc.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate4.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Course course = new Course("Docker ");
            Review review = new Review("excellent container");
            Review review2 = new Review("good ms orchestrating");
            Review review3 = new Review("best!");
            course.addReview(review);
            course.addReview(review2);
            course.addReview(review3);
            System.out.println("Saving the course");
            System.out.println(course.getReviews());
            session.save(course);
            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
