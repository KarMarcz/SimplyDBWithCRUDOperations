package karol.simply.simply.bootstrap;

import karol.simply.simply.Model.Author;
import karol.simply.simply.Model.Book;
import karol.simply.simply.Model.Publisher;
import karol.simply.simply.repositories.AuthorRepository;
import karol.simply.simply.repositories.BookRepository;
import karol.simply.simply.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDate();
    }

    private void initDate(){
        //karol
        Publisher wio = new Publisher();
        wio.setName("Wio");
        wio.setAddress("juraty14, Gdansk");
        publisherRepository.save(wio);

        Author karol = new Author("Karol", "Mlody");
        Book onTree = new Book("On Tree", "1234", wio);

        karol.getBooks().add(onTree);
        onTree.getAuthors().add(karol);

        authorRepository.save(karol);
        bookRepository.save(onTree);

        //Alicja
        Publisher magic = new Publisher();
        magic.setName("Magic");
        magic.setAddress("Norwida15, Wawa");
        publisherRepository.save(magic);

        Author alicja = new Author("Alicja", "Modna");
        Book wonderland = new Book("Wonderland", "2345", magic);

        alicja.getBooks().add(wonderland);
        wonderland.getAuthors().add(alicja);

        authorRepository.save(alicja);
        bookRepository.save(wonderland);

    }
}
