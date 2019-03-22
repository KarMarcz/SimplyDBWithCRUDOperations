package karol.simply.simply.repositories;

import karol.simply.simply.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
