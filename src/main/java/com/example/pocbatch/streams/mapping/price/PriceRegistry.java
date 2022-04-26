package com.example.pocbatch.streams.mapping.price;

import com.example.pocbatch.core.model.Price;
import com.example.pocbatch.streams.mapping.Registry;

import java.util.ArrayList;
import java.util.List;

public class PriceRegistry implements Registry {

    private List<Registry> prices;
    private PriceRegistryBuilder priceRegistryBuilder;

    private PriceRegistry(List<Registry> users, PriceRegistryBuilder priceRegistryBuilder) {
        this.prices = users;
        this.priceRegistryBuilder = priceRegistryBuilder;
    }

    public static class PriceRegistryBuilder {
        private List<Registry> registries = new ArrayList<>();

        public PriceRegistryBuilder() {
        }

        public PriceRegistryBuilder header(PriceHeader header) {
            registries.add(0, header);
            return this;
        }

        public PriceRegistryBuilder body(List<Price> prices) throws Exception {
            prices.forEach(price -> {
                registries.add(new PriceBody()
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
                        .build());
            });

            // se o header nao estiver preenchido.
            if (registries.get(0) == null && !(registries.get(0) instanceof PriceHeader)) {
//                registries.add(0, new PriceHeader()
//                        .toBuilder()
//                        .addedPrice("price.getAddedPrice()")
//                        .contextId("price.getAddedPrice()")
//                        .contextName("price.getAddedPrice()")
//                        .includedQuantity("price.getAddedPrice()")
//                        .price("price.getAddedPrice()")
//                        .orderType("price.getAddedPrice()")
//                        .productCode("price.getAddedPrice()")
//                        .productName("price.getAddedPrice()")
//                        .productType("price.getAddedPrice()").build());
            }
            return this;
        }

        public PriceRegistry build() {
            return new PriceRegistry(registries, this);
        }
    }

    public List<Registry> getUsers() {
        return prices;
    }

    public PriceRegistryBuilder getPriceRegistryBuilder() {
        return priceRegistryBuilder;
    }
}
