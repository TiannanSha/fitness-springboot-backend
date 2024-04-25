package com.fitness.demo.listing;

import com.fitness.demo.forms.ListingForm;
import com.fitness.demo.forms.ListingFormConverter;
import com.fitness.demo.user.User;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ListingController {

    @Autowired
    ListingService listingService;
    ListingFormConverter converter = new ListingFormConverter();

    @GetMapping("/api/v1/{seller}/listing)")
    public List<Listing> getListingsBySeller(@PathVariable String seller) {
        return listingService.getListingsBySeller(seller);
    }

    @GetMapping(value="/api/v1/listing")
    public List<Listing> getAllListings() {
        return listingService.getAllListings();
    }

    @PostMapping(value="/api/v1/listing")
    public Listing postListing(@Valid ListingForm listingForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
        } else {
            System.out.println("ok");
        }
        Listing listing = converter.convertForm(listingForm);
        return listingService.createListing(listing);
    }

    @GetMapping(value="api/v1/listing/{pageId}/{pageSize}")
    public List<Listing> getListingByPage(@PathVariable int pageId, @PathVariable int pageSize)
    {
        return listingService.getListingsByPage(pageId, pageSize);
    }

    @GetMapping(value="api/v1/listing/{keyword}")
    public List<Listing> getListingByKeyword(@PathVariable String keyword) {
        return listingService.getAllListingsByKeyword(keyword);
    }
}
