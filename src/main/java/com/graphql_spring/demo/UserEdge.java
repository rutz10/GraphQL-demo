package com.graphql_spring.demo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
public class UserEdge {
    private ObjectId cursor;
    private User node;
}
