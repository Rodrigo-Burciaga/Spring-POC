package com.rodrigo.poc.hibernate2.onetoone.unidirectional;

import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import com.rodrigo.poc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            System.out.println("Creating new instructor ");
            Instructor instructor = new Instructor("Jordan", "Belfort", "belfort@live.com ");
            System.out.println("Creating new instructor detail ");
            InstructorDetail instructorDetail = new InstructorDetail("straton", "invest");
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor");
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
