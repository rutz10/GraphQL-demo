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
