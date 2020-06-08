package com.rodrigo.poc.hibernate3.onetoonebidirectional;

import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            int id = 10000;
            session.beginTransaction();
            System.out.println("Getting instructor detail object with id: " + id);
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println("Instructor detail retrieved: " + instructorDetail);
            System.out.println("Instructor object associated: " + instructorDetail.getInstructor());
            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println("Caching");
            e.printStackTrace();
        }

    }
}
