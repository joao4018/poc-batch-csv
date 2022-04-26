package com.example.pocbatch.streams.configuration;

import com.example.pocbatch.core.model.Price;
import com.example.pocbatch.streams.enums.StreamName;
import com.example.pocbatch.streams.mapping.price.PriceBody;
import com.example.pocbatch.streams.mapping.price.PriceHeader;
import org.beanio.StreamFactory;
import org.beanio.builder.CsvParserBuilder;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.FixedLengthParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileStreamFactory {


    @Bean
    public StreamFactory streamFactory() {
        StreamFactory factory = StreamFactory.newInstance();


//        // Definindo os streams factorys para o mapeamento usuario.
//        StreamBuilder builderFixedLength = new StreamBuilder(StreamName.USER_FIXED_LENGTH.getStream());
//        StreamBuilder builderDelimited = new StreamBuilder(StreamName.USER_DELIMITED.getStream());
        StreamBuilder builderCsv = new StreamBuilder(StreamName.PRICE_CSV.getStream());

//
//        //Formatos possiveis
//        builderFixedLength.format("fixedlength")
//                .parser(new FixedLengthParserBuilder())
//                .addRecord(UserHeader.class)
//                .addRecord(UserBody.class)
//                .build();
//
//        builderDelimited.format("delimited")
//                .parser(new DelimitedParserBuilder('|'))
//                .addRecord(UserHeader.class)
//                .addRecord(UserBody.class)
//                .build();

        builderCsv.format("csv")
                .parser(new CsvParserBuilder())
                .addRecord(PriceHeader.class)
                .addRecord(PriceBody.class)
                .build();


//        factory.define(builderFixedLength);
//        factory.define(builderDelimited);
        factory.define(builderCsv);

        return factory;
    }
}
