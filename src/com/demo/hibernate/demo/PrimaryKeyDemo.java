package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session =  factory.getCurrentSession();
		
		try {
			System.out.println("Creating 3 Student Object...");
			
			Student tempStudent1 = new Student("Paul", "Wall", "pw@email.com");
			Student tempStudent2 = new Student("John", "Doe", "jd@email.com");
			Student tempStudent3 = new Student("Marie", "Paul", "mp@email.com");
			
			session.beginTransaction();
			
			System.out.println("Saving Student to Database...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}
}
