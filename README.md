GraphQL Spring Boot Application with MongoDB and Cursor-Based Pagination

This repository contains a Spring Boot application with GraphQL, MongoDB, and Lombok. The application demonstrates cursor-based pagination for handling large datasets.
Prerequisites

    Java 17
    MongoDB
    Gradle


Configure MongoDB:
Ensure MongoDB is running locally on the default port (27017).

Update Application Properties:
src/main/resources/application.properties

properties

spring.data.mongodb.uri=mongodb://localhost:27017/graphql_db
spring.graphql.schema.printer.enabled=true
server.port=8085

Build the Project:

sh

./gradlew build

Run the Application:

sh

    ./gradlew bootRun

GraphQL Endpoints http://127.0.0.1:8085/graphiql
Queries

Fetch Users with Pagination:

graphql

query {
  users(first: 10) {
    edges {
      cursor
      node {
        _id
        name
        email
      }
    }
    pageInfo {
      endCursor
      hasNextPage
    }
  }
}

Fetch Next Set of Users:

graphql

query {
  users(first: 10, after: "END_CURSOR_FROM_PREVIOUS_RESULT") {
    edges {
      cursor
      node {
        _id
        name
        email
      }
    }
    pageInfo {
      endCursor
      hasNextPage
    }
  }
}


To create a demo users collection in MongoDB and 1000 data points

const documents = [];
for (var i = 0; i < 1000; i++) {
  documents.push({
    tp: "generated_id_" + i,  // Generate unique IDs (modify as needed)
    name: "Sample Name " + i,
    email: "sample" + i + "@example.com"
  });
}

db.users.insertMany(documents);

For querying the Graphql 
query {
  users(first: 10,
  after: "66568784df505ce9f7924ef5") {
    edges {
      cursor
      node {
        _id
        name
        email
      }
    }
    pageInfo {
      endCursor
      hasNextPage
    }
  }
}
