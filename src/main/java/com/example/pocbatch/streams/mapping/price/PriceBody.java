package com.example.pocbatch.streams.mapping.price;

import com.example.pocbatch.streams.mapping.Registry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class PriceBody implements Registry {

    @Field(name = "Product Code")
    private String productCode;
    @Field(name = "Product Type")
    private String productType;
    @Field(name = "Product Name")
    private String productName;
    @Field(name = "Context Id")
    private String contextId;
    @Field(name = "Context Name")
    private String contextName;
    @Field(name = "Order Type")
    private String orderType;
    @Field(name = "Price")
    private String price;
    @Field(name = "Added Price")
    private String addedPrice;
    @Field(name = "Included Quantity")
    private String includedQuantity;

}
