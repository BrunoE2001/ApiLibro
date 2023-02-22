import { gql } from "apollo-server";

export const typeDefs = gql`
    type Books {
        id: ID!
        Descripcion: String!
        autor: String!
        precio: Int!
    }

    type Query {
      books: [Books!]!
    }
`;

// module.exports = { typeDefs };