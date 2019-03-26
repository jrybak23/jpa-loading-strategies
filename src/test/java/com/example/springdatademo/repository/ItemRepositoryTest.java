package com.example.springdatademo.repository;

import com.example.springdatademo.BaseTest;
import com.example.springdatademo.domain.Item;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author Igor Rybak
 * @since 26-Mar-2019
 */
@DBRider
public class ItemRepositoryTest extends BaseTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DataSet("dataset.xml")
    public void test() {
        List<Sort.Order> orders = Arrays.asList(
                Sort.Order.asc("name"),
                Sort.Order.asc("count")
        );

        PageRequest pageable = PageRequest.of(0, 10, Sort.by(orders));
        Page<Item> page = itemRepository.findAll(pageable);

        page.forEach(System.out::println);
    }
}