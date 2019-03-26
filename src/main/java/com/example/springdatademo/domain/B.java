package com.example.springdatademo.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@NamedEntityGraph(name = B.EG1, attributeNodes = {
        @NamedAttributeNode(value = "a")
})
@Table(name = "b")
public class B {
    public static final String EG1 = "b_eg1";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "a_id", nullable = false)
    private A a;

    @OneToMany(mappedBy = "b")
    @Fetch(FetchMode.SUBSELECT)
    private List<C> cs;

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

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public List<C> getCs() {
        return cs;
    }

    public void setCs(List<C> cs) {
        this.cs = cs;
    }

    @Override
    public String toString() {
        return "B{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
