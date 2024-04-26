package com.fitness.demo.forms;

import com.fitness.demo.listing.Listing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ListingDTOConverterTest {
    ListingDTO listingDTO = new ListingDTO("skis", 439.0, "sha");

    @Test
    public void testConvertingListingForm() {
        Listing listing = ListingDTO.convertToListing(listingDTO);
        assertEquals(439, listing.getPrice());
        assertEquals("skis", listing.getDescription());
        assertEquals("sha", listing.getSeller());
    }
}