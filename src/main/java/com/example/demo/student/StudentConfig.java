package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args ->
        {
            Student mariam = new Student(
                    1L,
                    "Mariam",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "mariam@gmail.com"
            );
            Student sehyun = new Student(
                    2L,
                    "Sehyun",
                    LocalDate.of(1995, Month.JULY, 12),
                    "sehyun@gmail.com"
            );

            // save database
            repository.saveAll(
                    List.of(mariam, sehyun)
            );
        };
    }

}
