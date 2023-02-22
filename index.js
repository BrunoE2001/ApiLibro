import { ApolloServer } from "apollo-server";
import { typeDefs } from "./schemas/type-defs.js";
import { resolvers } from "./schemas/resolvers.js";

const server = new ApolloServer({ typeDefs, resolvers });

server.listen().then(({ url }) => {
    console.log(`YOUR APP IS RUNNING at: ${url} )`);
});