package com.core.config.batch.reader;

import com.core.domain.Person;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorReaderConfig {

    @Bean
    public JdbcCursorItemReader<Person> jdbcCursorReader() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/db-core?useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("postgres");
        dataSource.setPassword("changeme");
        return new JdbcCursorItemReaderBuilder<Person>()
                .name("jdbcCursorReader")
                .dataSource(dataSource)
                .sql("select * from person")
                .rowMapper(new BeanPropertyRowMapper<Person>(Person.class))
                .build();
    }
}
