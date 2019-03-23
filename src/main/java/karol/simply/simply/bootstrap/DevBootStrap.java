package karol.simply.simply.bootstrap;

import karol.simply.simply.Model.Author;
import karol.simply.simply.Model.Book;
import karol.simply.simply.repositories.AuthorRepository;
import karol.simply.simply.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDate();
    }
    private void initDate(){
        //karol
        Author karol = new Author("Karol", "Mlody");
        Book onTree = new Book("On Tree", "1234", "Wio");
        karol.getBooks().add(onTree);
        onTree.getAuthors().add(karol);

        authorRepository.save(karol);
        bookRepository.save(onTree);

        //Alicja
        Author alicja = new Author("Alicja", "Modna");
        Book wonderland = new Book("Wonderland", "2345", "LPP");
        alicja.getBooks().add(wonderland);

        authorRepository.save(alicja);
        bookRepository.save(wonderland);
    }
}
