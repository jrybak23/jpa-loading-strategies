package com.example.springdatademo.repository;

import com.example.springdatademo.domain.A;
import com.example.springdatademo.domain.B;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.example.springdatademo.JPAHints.ENTITY_GRAPH;

/**
 * @author Igor Rybak
 * @since 26-Mar-2019
 */
@Repository
public class BDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<B> findAll() {
        return entityManager.createQuery("from B b", B.class)
                //.setHint(ENTITY_GRAPH, entityManager.getEntityGraph(B.EG1))
                .getResultList();
    }
}
