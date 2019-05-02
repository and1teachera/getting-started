package com.zlatenov.gettingstarted.repository;

import com.zlatenov.gettingstarted.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Angel Zlatenov
 */

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
