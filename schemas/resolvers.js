import { BooksList } from "../data.js";

export const resolvers = {
    Query: {
        books() {
            return BooksList;
        },
    },
};


// module.exports = {resolvers};