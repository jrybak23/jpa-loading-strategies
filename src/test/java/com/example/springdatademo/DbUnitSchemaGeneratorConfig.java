package com.example.springdatademo;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Igor Rybak
 * @since 31-Oct-2018
 */
@TestConfiguration
public class DbUnitSchemaGeneratorConfig {
    @Autowired
    public void generateDTD(DataSource dataSource, EntityManagerFactory entityManagerFactory)
            throws SQLException, DatabaseUnitException, IOException {
        IDatabaseConnection connection = new DatabaseConnection(dataSource.getConnection());
        File file = new File("src/test/resources/datasets/schema.dtd");
        FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream(file));
    }
}
