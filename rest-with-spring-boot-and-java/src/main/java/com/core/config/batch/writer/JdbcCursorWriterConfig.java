package com.core.config.batch.writer;

import com.core.domain.Person;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcCursorWriterConfig {

    @Bean
    public ItemWriter<Person> jdbcCursorWriter() {
        return persons -> persons.forEach(System.out::println);
    }
}
