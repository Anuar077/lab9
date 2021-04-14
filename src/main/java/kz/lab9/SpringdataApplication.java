package kz.lab9;

import kz.lab9.Book.Book;
import kz.lab9.Book.BookRepository;
import kz.lab9.Course.Course;
import kz.lab9.Course.CourseRepository;
import kz.lab9.Student.Student;
import kz.lab9.Student.StudentRepository;
import kz.lab9.User.User;
import kz.lab9.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        Student a = new Student(1, "New");
        Course c = new Course(1,"New c");
        Book b  = new Book(1, "New b");
        User u = new User(1, "New u");
        List<Student> people = Arrays.asList(a);
        List<Course> course = Arrays.asList(c);
        List<Book> book= Arrays.asList(b);
        List<User> user= Arrays.asList(u);
        studentRepository.saveAll(people);
        courseRepository.saveAll(course);
        bookRepository.saveAll(book);
        userRepository.saveAll(user);
        System.out.println("<<<<<<<<" + studentRepository.findAll()+courseRepository.findAll()+bookRepository.findAll()+userRepository.findAll());
    }
}