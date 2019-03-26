package com.example.springdatademo.repository;

import com.example.springdatademo.domain.A;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Igor Rybak
 * @since 26-Mar-2019
 */
public interface ARepository extends JpaRepository<A, Long> {

}
