package com.fitness.demo.listing;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Listing {
    ObjectId objectId;
    String description;
    Double price;
    String seller;

    public Listing(String description, double price, String seller) {
        this.description = description;
        this.price = price;
        this.seller = seller;
    }
}
