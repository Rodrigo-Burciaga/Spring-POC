package com.rodrigo.poc.hibernate7.manytomany;

import com.rodrigo.poc.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndStudentsDemo {

    public static void main(String... args) {

        try (SessionFactory factory = new Configuration().configure("hibernate5.cfg.xml")
                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Course course = new Course("Machine Learning ");
            session.save(course);
            System.out.println("Saving the course");


            Student student = new Student("Elon", "Musk", "@elon");
            Student student2 = new Student("Warren", "Buffet", "buffet@live.com");
            Student student3 = new Student("Jeff", "Bezzos", "jeff@amazon.com");
            Student student4 = new Student("Marck", "Zucaritas", "marck@face.com");
            course.addStudent(student);
            course.addStudent(student2);
            course.addStudent(student3);
            course.addStudent(student4);

            session.save(student);
            session.save(student2);
            session.save(student3);
            session.save(student4);
            System.out.println("Saving the students");


            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
