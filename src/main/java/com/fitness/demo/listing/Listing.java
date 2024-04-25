package com.fitness.demo.listing;

import com.fitness.demo.forms.ListingFormConverter;
import com.fitness.demo.user.User;
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
    double price;
    String seller;

    public Listing(String description, double price, String seller) {
        this.description = description;
        this.price = price;
        this.seller = seller;
    }
}
