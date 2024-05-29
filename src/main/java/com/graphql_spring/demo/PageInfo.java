package com.graphql_spring.demo;


import org.bson.types.ObjectId;

public class PageInfo {
    private ObjectId endCursor;
    private boolean hasNextPage;

    public PageInfo(ObjectId endCursor, boolean hasNextPage) {
        this.endCursor = endCursor;
        this.hasNextPage = hasNextPage;
    }

    // Getters and Setters
}
