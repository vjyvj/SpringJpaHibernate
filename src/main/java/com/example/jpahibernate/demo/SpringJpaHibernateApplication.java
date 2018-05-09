package com.example.jpahibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpahibernate.demo.entity.Course;
import com.example.jpahibernate.demo.repository.CourseRepository;

@SpringBootApplication
public class SpringJpaHibernateApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = courseRepository.findById(1l);
		//logger.info("Find by Id of 1->{}",course);
		//logger.info("Delete by Id of 1");
		//courseRepository.deleteById(1l);
		//logger.info("Find by Id of 1->{}",course);
		courseRepository.playWithEntityManager();
		
	}
}
