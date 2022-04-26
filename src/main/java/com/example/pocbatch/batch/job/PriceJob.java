package com.example.pocbatch.batch.job;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class PriceJob {

    private JobBuilderFactory jobBuilderFactory;

    /**
     * Job responsavel por realizar a chamada dos steps de escrita do arquivo.
     */
    @Bean
    public Job sampleJob(@Qualifier("stepWriterUsersDB") Step priceStepWriterDB
    ) {
        return this.jobBuilderFactory.get("PRICE_JOB_CREATE")
                .incrementer(new RunIdIncrementer())
                .start(priceStepWriterDB)
                .build();


    }
}
