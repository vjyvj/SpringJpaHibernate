package com.example.jpahibernate.demo.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpahibernate.demo.entity.Student;
import com.example.jpahibernate.demo.entity.Passport;
import com.example.jpahibernate.demo.entity.Review;
import com.example.jpahibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	private EntityManager em;
	
	public Student findById(long id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(long id) {
		Student Student = em.find(Student.class, id);
		em.remove(Student);
	}
	
	public void playWithEntityManager() {
		Passport passport = new Passport(4001,"Z12345");
		em.persist(passport);
		Student student = new Student(2000,"Vijay");
		student.setPassport(passport);
		em.persist(student);
		
		
	}
}
