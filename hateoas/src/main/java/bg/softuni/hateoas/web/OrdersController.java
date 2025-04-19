package bg.softuni.hateoas.web;

import bg.softuni.hateoas.model.Course;
import bg.softuni.hateoas.model.Order;
import bg.softuni.hateoas.model.OrderDTO;
import bg.softuni.hateoas.model.Student;
import bg.softuni.hateoas.repository.CourseRepository;
import bg.softuni.hateoas.repository.OrderRepository;
import bg.softuni.hateoas.repository.StudentRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final StudentRepository studentRepository;
    private final OrderRepository orderRepository;
    private final CourseRepository courseRepository;

    public OrdersController(StudentRepository studentRepository, OrderRepository orderRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.orderRepository = orderRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public ResponseEntity<EntityModel<OrderDTO>>createOrder(
            @RequestBody OrderDTO orderDTO){
        Student student=studentRepository.getReferenceById(orderDTO.getStudentId());
        Course course = courseRepository.getReferenceById(orderDTO.getCourseId());

        Order order = new Order();
        order.setStudent(student)
                .setCourse(course);

        order = this.orderRepository.save(order);


        return ResponseEntity.ok(EntityModel.of(OrderDTO.asDTO(order)));
    }
}
