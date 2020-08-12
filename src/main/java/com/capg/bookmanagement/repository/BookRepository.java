package com.capg.bookmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.bookmanagement.dto.BookDTO;
@Repository
public interface BookRepository extends JpaRepository<BookDTO, String> {

}
