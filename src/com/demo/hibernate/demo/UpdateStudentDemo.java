package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			session = factory.getCurrentSession();
			session.beginTransaction();

			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("Mirakie");

			session.getTransaction().commit();
			System.out.println("Done!");

			session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("update Student s set email = 'mw@email.com' where s.firstName = 'Mirakie' ")
					.executeUpdate();

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
