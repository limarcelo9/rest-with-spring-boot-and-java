package com.core.config.batch.step;

import com.core.domain.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JdbcCursorReaderStepConfig {

    @Bean
    public Step jdbcCursorReaderStep(JobRepository jobRepository,
                                     PlatformTransactionManager transactionManager,
                                     @Qualifier("jdbcCursorReader") ItemReader<Person> jdbcCursorReader,
                                     @Qualifier("jdbcCursorWriter") ItemWriter<Person> jdbcCursorWriter){
        return new StepBuilder("jdbcCursorReaderStep", jobRepository)
                .<Person, Person>chunk(1, transactionManager)
                .reader(jdbcCursorReader)
                .writer(jdbcCursorWriter)
                .build();
    }




}
