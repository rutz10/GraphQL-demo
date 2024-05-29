package com.graphql_spring.demo;

import java.util.List;

public class UserConnection {
    private List<UserEdge> edges;
    private PageInfo pageInfo;

    public UserConnection(List<UserEdge> edges, PageInfo pageInfo) {
        this.edges = edges;
        this.pageInfo = pageInfo;
    }

    // Getters and Setters
}
