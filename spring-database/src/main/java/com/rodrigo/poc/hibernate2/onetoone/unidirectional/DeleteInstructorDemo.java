package com.rodrigo.poc.hibernate2.onetoone.unidirectional;

import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            int id = 2;
            session.beginTransaction();
            System.out.println("Deleting instructor object with id: " + id);
            Instructor instructor = session.get(Instructor.class, id);
            System.out.println("Instructor retrieved: " + instructor);
            if (instructor != null) {
                System.out.println("Deleting instructor" + instructor);
                session.delete(instructor);
            }
            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
