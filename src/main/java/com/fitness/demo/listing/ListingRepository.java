package com.fitness.demo.listing;

import com.fitness.demo.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListingRepository extends CrudRepository<Listing, ObjectId> {

    Listing save(Listing listing);

    List<Listing> findAll();

    List<Listing> findListingsBySeller(String seller);

    Slice<Listing> findAll(Pageable pageable);

    List<Listing> findByDescriptionContaining(String keyword);
}
