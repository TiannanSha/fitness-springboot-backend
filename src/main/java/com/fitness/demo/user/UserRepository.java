package com.fitness.demo.user;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, ObjectId> {

        User save(User user);

        Optional<User> findById(ObjectId objectId);

        List<User> findAll();

        long count();

        void delete(User entity);

        boolean existsById(ObjectId objectId);

        User findByUserName(String userName);


}
