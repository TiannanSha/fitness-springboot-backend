package com.fitness.demo.user;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

        User save(User user);

        List<User> findAll();

        long count();

        void delete(User entity);

        User findByUsername(String userName);


}
