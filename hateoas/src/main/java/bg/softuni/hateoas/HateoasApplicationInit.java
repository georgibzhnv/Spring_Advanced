package bg.softuni.hateoas;

import bg.softuni.hateoas.model.Course;
import bg.softuni.hateoas.model.Order;
import bg.softuni.hateoas.model.Student;
import bg.softuni.hateoas.repository.CourseRepository;
import bg.softuni.hateoas.repository.OrderRepository;
import bg.softuni.hateoas.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HateoasApplicationInit implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final OrderRepository orderRepository;
    private final CourseRepository courseRepository;

    public HateoasApplicationInit(StudentRepository studentRepository, OrderRepository orderRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.orderRepository = orderRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student ivan = new Student();
        ivan.setName("Ivan")
                .setAge(21);

        studentRepository.save(ivan);

        Course springDataCourse = new Course();
        springDataCourse.setEnabled(true)
                .setName("Spring Data")
                .setPrice(100.0);

        Course springBatchCourse = new Course();
        springBatchCourse.setEnabled(false)
                .setPrice(150.0)
                .setName("Spring Batch");

        courseRepository.save(springDataCourse);
        courseRepository.save(springBatchCourse);

        Order ivanSpringData = new Order();
        ivanSpringData.setCourse(springDataCourse)
                .setStudent(ivan);

        orderRepository.save(ivanSpringData);
    }
}
