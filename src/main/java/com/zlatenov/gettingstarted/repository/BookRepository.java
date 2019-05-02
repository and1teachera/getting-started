package com.zlatenov.gettingstarted.repository;

import com.zlatenov.gettingstarted.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Angel Zlatenov
 */

public interface BookRepository extends CrudRepository<Book,Long> {
}
