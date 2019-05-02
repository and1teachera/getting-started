package com.zlatenov.gettingstarted.repository;

import com.zlatenov.gettingstarted.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Angel Zlatenov
 */

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
