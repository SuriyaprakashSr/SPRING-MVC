package com.ty.springmvc_prc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ty.springmvc_prc.dto.Student;


@Repository
public class StudentDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Student savestudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

		return student;
	}

	public void  UpdateStudent(Student student) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();

	}

	public void  deleteStudent(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student=entityManager.find(Student.class, id);


		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();

	}

	public Student  getStudentById(int id) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		return entityManager.find(Student.class, id);
		

	}

	public List <Student>getAllStudent() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();


		Query query = entityManager.createQuery("select s from Student s");

		return query.getResultList();



	}
	
	public Student getStudentByEmail(String email) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();


		Query query = entityManager.createQuery("select s from Student s  where s.email=?1",Student.class);

		return (Student)query.setParameter(1, email).getSingleResult();



	}



}
