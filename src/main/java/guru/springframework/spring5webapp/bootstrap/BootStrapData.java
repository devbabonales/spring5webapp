package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData  implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository)  {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Deelopment without EJB", "23455");
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save((noEJB));

        System.out.println(("Started in Bootstrap!"));
        System.out.println("Number of Books : " + bookRepository.count());

    }
}
