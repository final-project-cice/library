package com.trl.libraryservice.repository;

import com.trl.libraryservice.repository.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is designed to support JPA for {@literal BookEntity}.
 *
 * @author Tsyupryk Roman
 */
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
