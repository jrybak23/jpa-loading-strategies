package com.example.springdatademo.repository;

import com.example.springdatademo.BaseTest;
import com.example.springdatademo.domain.A;
import com.example.springdatademo.domain.B;
import com.example.springdatademo.dto.ADTO;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Igor Rybak
 * @since 26-Mar-2019
 */
@DBRider
public class ARepositoryTest extends BaseTest {
    @Autowired
    private ARepository aRepository;

    @Autowired
    private ADAO adao;

    @Autowired
    private BDAO bdao;

    @Test
    @DataSet("dataset2.xml")
    @Transactional(readOnly = true)
    public void test() {
        List<A> result = adao.findAll();
        /*List<C> list = result.stream()
                .flatMap(a -> a.getBs().stream())
                .flatMap(b -> b.getCs().stream())
                .collect(toList());*/

        List<B> bs = result.stream()
                .flatMap(a -> a.getBs().stream())
                .collect(toList());

        System.out.println(bs);
    }

    @Test
    @DataSet("dataset2.xml")
    @Transactional(readOnly = true)
    public void test2() {
        List<B> results = bdao.findAll();

        results.get(0).getCs().forEach(System.out::println);
        results.get(1).getCs().forEach(System.out::println);
        results.get(2).getCs().forEach(System.out::println);

       /* List<C> cs = results.stream()
                .peek(b -> System.out.println(b.getA()))
                .flatMap(b -> b.getCs().stream())
                .collect(toList());
*/

        //System.out.println(cs);
    }

    @Test
    @DataSet("dataset2.xml")
    @Transactional(readOnly = true)
    public void testDTO() {
        List<ADTO> result = adao.findAllDTO();
        System.out.println(result);
    }
}