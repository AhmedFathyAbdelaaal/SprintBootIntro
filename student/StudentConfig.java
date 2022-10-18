package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ahmed = new Student(
                    1L,
                    "Ahmed",
                    "Ahmed@gmail.com",
                    LocalDate.of(2001, 5, 14)
            );
            Student mohammad = new Student(
                    2L,
                    "Mohammad",
                    "Mohammad@gmail.com",
                    LocalDate.of(2004, 5, 25)
            );

            repository.saveAll(List.of(ahmed,mohammad));
        };
    }
}
