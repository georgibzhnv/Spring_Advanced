package bg.softuni.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class RestApplicationInit implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
    ResponseEntity<List<Author>>authors = restTemplate.exchange("http://localhost:8080/authors",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Author>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
    if (authors.hasBody()){
        authors.getBody().forEach(System.out::println);
    }
    }
}
