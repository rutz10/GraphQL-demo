package com.graphql_spring.demo;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    List<User> findBy_idGreaterThan(ObjectId id, Pageable pageable);
}
