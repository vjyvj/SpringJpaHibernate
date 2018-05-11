package com.example.jpahibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpahibernate.demo.entity.Review;
import com.example.jpahibernate.demo.repository.CourseRepository;
import com.example.jpahibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class SpringJpaHibernateApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Course course = courseRepository.findById(1l);
		//logger.info("Find by Id of 1->{}",course);
		//logger.info("Delete by Id of 1");
		//courseRepository.deleteById(1l);
		//logger.info("Find by Id of 1->{}",course);
		courseRepository.playWithEntityManager();
		//courseRepository.addReviewForCourseHardcoded();
		List<Review> reviews = new ArrayList();
		Review review3 = new Review(4006,5, "Wow course");
		Review review4 = new Review(4007,4, "Nice course");
		reviews.add(review3);
		reviews.add(review4);
		courseRepository.addReviewForCourseDynamic(1000l,reviews);
		//studentRepository.playWithEntityManager();
		
	}
}
