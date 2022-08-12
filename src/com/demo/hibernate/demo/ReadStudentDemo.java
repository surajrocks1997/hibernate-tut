package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating new Student Object...");
			Student tempStudent = new Student("Daffu", "Duck", "dd@email.com");

			session.beginTransaction();

			System.out.println("Saving Student to Database...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			session.getTransaction().commit();

//			code to read from db
			System.out.println("Saved Student. Generated Id: " + tempStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Retrieve Complete. " + myStudent);
			
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
