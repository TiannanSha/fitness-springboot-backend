package com.fitness.demo.forms;

import com.fitness.demo.listing.Listing;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


@AllArgsConstructor
@NoArgsConstructor
public class ListingDTO {

//    private static final ListingDTOConverter converter = new ListingDTOConverter();

    @NotBlank
    @Size(min = 2, max = 100)
    String description;

    @DecimalMin("0.0")
    Double price;

    @NotBlank
    String seller;


    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getSeller() {
        return seller;
    }

    public static Listing convertToListing(ListingDTO dto) {
        return new ListingDTOConverter().convertDTO(dto);
    }


    private static class ListingDTOConverter implements DTOConverter<ListingDTO, Listing> {

        @Override
        public Listing convertDTO(ListingDTO listingDTO) {
            Listing listing = new Listing();
            BeanUtils.copyProperties(listingDTO, listing);
            return listing;
        }
    }
}
