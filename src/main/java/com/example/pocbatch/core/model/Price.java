package com.example.pocbatch.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.beanio.annotation.Field;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PRICE")
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder(toBuilder = true)
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Field(name = "Product_Code")
    private String productCode;
    @Field(name = "Product_Type")
    private String productType;
    @Field(name = "Product_Name")
    private String productName;
    @Field(name = "Context_Id")
    private String contextId;
    @Field(name = "Context_Name")
    private String contextName;
    @Field(name = "Order_Type")
    private String orderType;
    @Field(name = "Price")
    private String price;
    @Field(name = "Added_Price")
    private String addedPrice;
    @Field(name = "Included_Quantity")
    private String includedQuantity;

}
