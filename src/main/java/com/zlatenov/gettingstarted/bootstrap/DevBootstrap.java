package com.zlatenov.gettingstarted.bootstrap;

import com.zlatenov.gettingstarted.model.Author;
import com.zlatenov.gettingstarted.model.Book;
import com.zlatenov.gettingstarted.repository.AuthorRepository;
import com.zlatenov.gettingstarted.repository.BookRepository;
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

    @Autowired
    public DevBootstrap(final AuthorRepository authorRepository, final BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){
        //Eric Evans
        Author ericEvans = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        ericEvans.getBooks().add(ddd);
        ddd.getAuthors().add(ericEvans);

        authorRepository.save(ericEvans);
        bookRepository.save(ddd);


        //Rod
        Author rodJohnson = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox" );
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
