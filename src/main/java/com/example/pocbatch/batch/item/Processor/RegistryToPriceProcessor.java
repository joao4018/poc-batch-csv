package com.example.pocbatch.batch.item.Processor;

import com.example.pocbatch.core.model.Price;
import com.example.pocbatch.streams.mapping.Registry;
import com.example.pocbatch.streams.mapping.price.PriceBody;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class RegistryToPriceProcessor implements ItemProcessor<Registry, Price> {

    @Override
    public Price process(Registry registry) {
        PriceBody price = (PriceBody) registry;

        return new Price()
                .toBuilder()
                .addedPrice(price.getAddedPrice())
                .contextId(price.getContextId())
                .contextName(price.getContextName())
                .includedQuantity(price.getIncludedQuantity())
                .price(price.getPrice())
                .orderType(price.getOrderType())
                .productCode(price.getProductCode())
                .productName(price.getProductName())
                .productType(price.getProductType())
                .build();
    }
}



