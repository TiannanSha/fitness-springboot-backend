package com.fitness.demo.forms;

import com.fitness.demo.listing.Listing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ListingFormConverterTest {
    ListingForm listingForm = new ListingForm("skis", 439);
    ListingFormConverter converter = new ListingFormConverter();

    @Test
    public void testConvertingListingForm() {
        Listing listing = converter.convertForm(listingForm);
        assertEquals(439, listing.getPrice());
        assertEquals("skis", listing.getDescription());
    }
}