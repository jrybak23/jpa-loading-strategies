package com.example.springdatademo.domain;


import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Igor Rybak
 * @since 26-Mar-2019
 */
@Entity
@Table(name = "a")
@NamedEntityGraph(name = A.EG1, attributeNodes = {
        @NamedAttributeNode(value = "bs")
})
public class A {
    public final static String EG1 = "a_eg1";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "a")
    @Fetch(FetchMode.JOIN)
    @BatchSize(size = 2)
    private List<B> bs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<B> getBs() {
        return bs;
    }

    public void setBs(List<B> bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
