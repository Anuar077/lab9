package kz.lab9.Book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.lab9.Course.Course;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Set<Course> course;

    private String name;

    public Book(int id, String name) {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourse() {
        return this.course;
    }

}