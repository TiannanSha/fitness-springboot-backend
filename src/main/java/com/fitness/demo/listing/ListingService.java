package com.fitness.demo.listing;

import com.fitness.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Autowired
    ListingRepository listingRepository;

    public Listing createListing(Listing listing) {
        Listing savedListing = listingRepository.save(listing);
        if (savedListing == null) return null;
        return savedListing;
    }

    public List<Listing> getListingsBySeller(String seller) {
        return listingRepository.findListingsBySeller(seller);
    }

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    public List<Listing> getListingsByPage(int pageId, int pageSize) {
        Slice<Listing> listingSlice = listingRepository.findAll(PageRequest.of(pageId, pageSize));
        return listingSlice.toList();
    }

    public List<Listing> getAllListingsByKeyword(String keyword) {
        return listingRepository.findByDescriptionContaining(keyword);
    }
}
