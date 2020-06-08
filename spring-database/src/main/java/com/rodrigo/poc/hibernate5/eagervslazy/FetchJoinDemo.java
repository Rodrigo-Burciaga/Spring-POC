package com.rodrigo.poc.hibernate5.eagervslazy;

import com.rodrigo.poc.entity.Course;
import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            int id = 1;
            session.beginTransaction();
            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses " +
                    "where i.id=:id", Instructor.class);
            Instructor instructor = query.setParameter("id", id).getSingleResult();
            System.out.println("---------------instructor: " + instructor);
            session.getTransaction().commit();
            System.out.println("---------------courses: " + instructor.getCourses());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
