package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Client -> API layer -> Service Layer -> Data access layer
 */
@SpringBootApplication
public class DemoApplication {
	// run server
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
