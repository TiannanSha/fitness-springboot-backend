package com.fitness.demo.listing;

import com.fitness.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ListingController {

    @Autowired
    ListingService listingService;

    @GetMapping("/api/v1/{seller}/listing)")
    public List<Listing> getListingsBySeller(@PathVariable String seller) {
        return listingService.getListingsBySeller(seller);
    }

    @GetMapping(value="/api/v1/listing")
    public List<Listing> getAllListings() {
        return listingService.getAllListings();
    }

    @PostMapping(value="/api/v1/listing")
    public Listing postListing(@RequestParam Map<String, String> params) {
        String seller = params.get("seller");
        double price = Double.parseDouble(params.get("price"));
        String description = params.get("description");
        Listing listing = new Listing(description, price, seller);
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
