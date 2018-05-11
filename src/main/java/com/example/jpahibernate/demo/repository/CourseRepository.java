package com.example.jpahibernate.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpahibernate.demo.entity.Course;
import com.example.jpahibernate.demo.entity.Review;

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
		
		Review review1 = new Review(4000,3,"Best course");
		review1.setCourse(course1);
		Review review2 = new Review(4001,1,"Not interesting");
		review2.setCourse(course2);
		Review review3 = new Review(4002,5,"Excellent coaching for beginers");
		review3.setCourse(course1);
		
		em.persist(review1);
		em.persist(review2);
		em.persist(review3);
		
	}
	
	public void addReviewForCourseHardcoded() {
		Course course = findById(1002l);
		
		Review review3 = new Review(4004,5, "Wow course");
		Review review4 = new Review(4005,4, "Nice course");
		
		course.addReview(review3);
		review3.setCourse(course);
		course.addReview(review4);
		review4.setCourse(course);
		
		em.persist(review3);
		em.persist(review4);
	}

	public void addReviewForCourseDynamic(Long courseId, List<Review> reviews) {
		
		Course course = findById(courseId);
		
		reviews.forEach(r-> {
			r.setCourse(course);
			course.addReview(r);
			em.persist(r);
		});
		
		
		
	}
}
