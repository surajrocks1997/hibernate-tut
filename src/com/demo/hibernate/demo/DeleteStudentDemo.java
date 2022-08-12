package com.demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			session = factory.getCurrentSession();
			session.beginTransaction();

			Student myStudent = session.get(Student.class, studentId);

//			session.delete(myStudent);

//			delete student id 2
			session.createQuery("delete from Student where id = 2").executeUpdate();
			System.out.println("Deleted!");

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
