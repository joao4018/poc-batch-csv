package com.example.pocbatch.batch.item.Reader;

import com.example.pocbatch.streams.configuration.FlatFileConfiguration;
import com.example.pocbatch.streams.enums.FlatFileOption;
import com.example.pocbatch.streams.enums.StreamName;
import com.example.pocbatch.streams.mapping.Registry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@StepScope
public class PriceItemReaderFile extends StepExecutionListenerSupport implements ItemReader<Registry> {

    @NonNull
    private FlatFileConfiguration<Registry> configuration;

    @Value("src/main/resources")
    private String path;

    @Override
    public void beforeStep(StepExecution stepExecution) {
//        String value = stepExecution.getJobExecution().getExecutionContext().getString("MY_VALUE");
        this.configuration.initialize(FlatFileOption.READER, StreamName.PRICE_CSV, path);
    }

    @Override
    public Registry read() {
        try {
            return this.configuration.getReader().read();
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro na leitura do registro", e);
        }
    }
}
