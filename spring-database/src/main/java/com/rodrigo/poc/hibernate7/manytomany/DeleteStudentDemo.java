package com.rodrigo.poc.hibernate7.manytomany;

import com.rodrigo.poc.entity.Course;
import com.rodrigo.poc.entity.Instructor;
import com.rodrigo.poc.entity.InstructorDetail;
import com.rodrigo.poc.entity.Review;
import com.rodrigo.poc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

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
            System.out.println("----------------courses: " + student.getCourses());
            System.out.println("Deleting student");
            session.delete(student);

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
