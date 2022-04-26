package com.example.pocbatch.streams.mapping.price;

import com.example.pocbatch.streams.mapping.Registry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.beanio.annotation.Field;
import org.beanio.annotation.Fields;
import org.beanio.annotation.Record;

@Record
@Fields({@Field(name = "Product Code", rid = true, literal = "Product Code")})
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class PriceHeader implements Registry {
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
