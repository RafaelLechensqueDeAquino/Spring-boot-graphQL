package com.lechensque.graphql.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lechensque.graphql.demo.resolver.BookResolver;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

@Configuration
public class GraphQLConfig {
    @Bean
    public GraphQLSchema graphQLSchema(BookResolver bookResolver) {
        return new GraphQLSchemaGenerator()
                .withOperationsFromSingleton(bookResolver)
                .generate();
    }

    @Bean
    public GraphQL graphQL(GraphQLSchema graphQLSchema) {
        return GraphQL.newGraphQL(graphQLSchema).build();
    }
}

