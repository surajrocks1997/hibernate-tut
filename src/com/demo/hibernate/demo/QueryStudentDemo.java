package com.demo.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email Like '%email.com'").getResultList();
			displayStudents(theStudents);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
