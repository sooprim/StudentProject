package edu.uacs.cip.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student jovan = new Student(
                    1L,
                    "Jovan",
                    "jovantone@hotmail.com",
                    LocalDate.of(2004, Month.APRIL, 28)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, Month.APRIL, 28)
            );
            repository.saveAll(
                    List.of(jovan, alex)
            );
        };
    }
}
