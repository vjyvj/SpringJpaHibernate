package com.example.jpahibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpahibernate.demo.entity.Course;

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
		Course course1 = new Course("Entity Manager");
		em.persist(course1);
		Course course2 = new Course("Angular Js");
		em.persist(course2);
		em.flush();
		
		//em.clear();
		course1.setName("Entity manager updated");
		course2.setName("Angular Js updated");
		
		System.out.println("@@@@@ course1 before refresh--"+course1.getName());
		em.refresh(course1);
		
		System.out.println("@@@@@ course1 after refresh--"+course1.getName());
		em.flush();
		
		System.out.println("@@@@@ course1 after flush--"+course1.getName());
		
	}
}
