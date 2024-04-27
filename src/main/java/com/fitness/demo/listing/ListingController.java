package com.fitness.demo.listing;

import com.fitness.demo.exception.BadRequestException;
import com.fitness.demo.forms.ListingDTO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
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
    public ResponseEntity<Listing> postListing(@Valid @RequestBody ListingDTO listingDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            throw new BadRequestException(bindingResult);
        } else {
            System.out.println("ok");
        }
        Listing listing = ListingDTO.convertToListing(listingDTO);
        return new ResponseEntity<>(listingService.createListing(listing), HttpStatus.CREATED);
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
