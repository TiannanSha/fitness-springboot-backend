package com.fitness.demo.forms;

import com.fitness.demo.listing.Listing;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

public class ListingFormConverter implements FormConverter<ListingForm, Listing> {

    @Override
    public Listing convertForm(ListingForm form) {
        Listing listing = new Listing();
        listing.setDescription(form.getDescription());
        listing.setPrice(form.getPrice());
        return listing;
    }
}
