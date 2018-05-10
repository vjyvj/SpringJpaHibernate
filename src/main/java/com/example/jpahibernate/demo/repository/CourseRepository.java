package com.example.jpahibernate.demo.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpahibernate.demo.entity.Course;
import com.example.jpahibernate.demo.entity.Passport;
import com.example.jpahibernate.demo.entity.Review;
import com.example.jpahibernate.demo.entity.Student;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager em;
	
	public Course findById(long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = em.find(Course.class, id);
		em.remove(course);
	}
	
	public void playWithEntityManager() {
		Course course1 = new Course(1000,"Entity Manager",LocalDateTime.now(),LocalDateTime.now());
		Course course2 = new Course(1001,"Angular Js",LocalDateTime.now(),LocalDateTime.now());
		Course course3 = new Course(1002,"Spring boot",LocalDateTime.now(),LocalDateTime.now());
		
		em.persist(course2);
		em.persist(course1);
		em.persist(course3);
		
		/*Student student1 = new Student(2000,"Vijay");
		Student student2 = new Student(2001,"Raghav");
		Student student3 = new Student(2002,"Suresh");
		
		em.persist(student1);
		em.persist(student2);
		em.persist(student3);
		
		Passport passport1 = new Passport(3000,"EJ123");
		Passport passport2 = new Passport(3001,"EJ456");
		Passport passport3 = new Passport(3002,"EJ789");
		
		em.persist(passport1);
		em.persist(passport2);
		em.persist(passport3);
		
		Review review1 = new Review(4000,3,"Best course");
		Review review2 = new Review(4001,1,"Not interesting");
		Review review3 = new Review(4002,5,"Excellent coaching for beginers");
		
		em.persist(review1);
		em.persist(review2);
		em.persist(review3);*/
		
		
		/*em.flush();
		course2.setName("Angular Js updated");
		em.flush();
		em.clear();
		course1.setName(null);
		em.persist(course1);
		course2.setName("Angular Js updated");
		em.flush();
		System.out.println("@@@@@ course1 before refresh--"+course1.getName());
		em.refresh(course1);
		
		System.out.println("@@@@@ course1 after refresh--"+course1.getName());
		em.flush();
		
		System.out.println("@@@@@ course1 after flush--"+course1.getName());*/
		
	}
}
