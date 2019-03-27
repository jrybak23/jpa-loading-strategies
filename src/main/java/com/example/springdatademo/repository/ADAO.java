package com.example.springdatademo.repository;

import com.example.springdatademo.domain.A;
import com.example.springdatademo.dto.ADTO;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
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
public class ADAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<A> findAll() {
        return entityManager.createQuery("select a from A a", A.class)
                .setHint(ENTITY_GRAPH, entityManager.getEntityGraph(A.EG1))
                .getResultList();
    }

    public List findAllDTO() {
        return entityManager.unwrap(Session.class).createQuery("select a.name as aName, a.bs as aBs from A a")
                .setResultTransformer(Transformers.aliasToBean(ADTO.class))
                .getResultList();
    }
}
