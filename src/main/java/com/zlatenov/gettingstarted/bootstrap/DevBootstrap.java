package com.zlatenov.gettingstarted.bootstrap;

import com.zlatenov.gettingstarted.model.Author;
import com.zlatenov.gettingstarted.model.Book;
import com.zlatenov.gettingstarted.model.Publisher;
import com.zlatenov.gettingstarted.repository.AuthorRepository;
import com.zlatenov.gettingstarted.repository.BookRepository;
import com.zlatenov.gettingstarted.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Angel Zlatenov
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap(final AuthorRepository authorRepository, final BookRepository bookRepository, final PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        //Eric Evans
        Author ericEvans = new Author("Eric", "Evans");
        Publisher addisonWesley = new Publisher("Addison Wesley", "Addison Wesley Street");
        publisherRepository.save(addisonWesley);
        Book ddd = new Book("Domain Driven Design", "1234", addisonWesley);
        ericEvans.getBooks().add(ddd);
        ddd.getAuthors().add(ericEvans);

        authorRepository.save(ericEvans);
        bookRepository.save(ddd);


        //Rod
        Author rodJohnson = new Author("Rod", "Johnson");
        Publisher packt = new Publisher("Packt", "Packt Street");
        publisherRepository.save(packt);
        Book noEJB = new Book("J2EE Development without EJB", "23444", packt );
        rodJohnson.getBooks().add(noEJB);
        noEJB.getAuthors().add(rodJohnson);

        authorRepository.save(rodJohnson);
        bookRepository.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
