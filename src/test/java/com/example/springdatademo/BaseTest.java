package com.example.springdatademo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Igor Rybak
 * @since 26-Mar-2019
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Import(value = DbUnitSchemaGeneratorConfig.class)
public abstract class BaseTest {

}
