package karol.simply.simply.repositories;

import karol.simply.simply.Model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
