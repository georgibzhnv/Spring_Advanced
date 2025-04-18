package bg.softuni.hateoas.web;

import bg.softuni.hateoas.model.Course;
import bg.softuni.hateoas.repository.CourseRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private final CourseRepository courseRepository;

    public CoursesController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Course>>>getAllCourses(){
        List<EntityModel<Course>>courses = courseRepository
                .findAll()
                .stream()
                .map(course -> EntityModel.of(course,createCourseLinks(course)))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(courses,
                linkTo(methodOn(CoursesController.class).getAllCourses())
                        .withSelfRel()));
    }

    private Link[] createCourseLinks(Course course){
        List<Link>result= new ArrayList<>();

        return  result.toArray(new Link[0]);
    }
}
