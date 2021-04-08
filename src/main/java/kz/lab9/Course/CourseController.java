package kz.lab9.Course;

import kz.lab9.Book.Book;
import kz.lab9.Book.BookRepository;
import kz.lab9.Student.Student;
import kz.lab9.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @PostMapping
    Course createSubject(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}/students/{studentId}")
   Course addStudentToCourse(
            @PathVariable Long courseId,
            @PathVariable Long studentId
    ) {
        Course course = courseRepository.findById(courseId).get();
        Student student = studentRepository.findById(studentId).get();
       course.enrolledStudents.add(student);
        return courseRepository.save(course);
    }

    @PutMapping("/{courseId}/book/{bookId}")
    Course assignTeacherToSubject(
            @PathVariable Long courseId,
            @PathVariable Long bookId
    ) {
        Course course = courseRepository.findById(courseId).get();
        Book book = bookRepository.findById(bookId).get();
       course.setBook(book);
        return courseRepository.save(course);
    }
}
