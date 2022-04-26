package com.example.pocbatch.batch.item.Writer;


import com.example.pocbatch.core.model.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;


@Component
@RequiredArgsConstructor
public class PriceItemWriterDB {


    private final EntityManagerFactory emf;

    @Bean("jpaPriceItemWriter")
    public JpaItemWriter<Price> writer() {
        JpaItemWriter<Price> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(emf);
        return writer;
    }

}
