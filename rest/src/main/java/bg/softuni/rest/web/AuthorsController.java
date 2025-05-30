package bg.softuni.rest.web;

import bg.softuni.rest.model.Author;
import bg.softuni.rest.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorsController implements AuthorsNamespace{

    private final AuthorRepository authorRepository;

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author>getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author>getAuthor(@PathVariable Long authorId){
        Optional<Author>theAuthor=authorRepository.findById(authorId);
        return theAuthor.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author author,
                                         UriComponentsBuilder ucBuilder
    ){
        Author newAuthor =authorRepository.save(author);
        return ResponseEntity.created(ucBuilder.path("/authors/{authorId}")
                .buildAndExpand(newAuthor.getId()).toUri()).build();
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Author>delete(@PathVariable Long authorId){
        authorRepository.deleteById(authorId);
        return  ResponseEntity.noContent().build();
    }
}
