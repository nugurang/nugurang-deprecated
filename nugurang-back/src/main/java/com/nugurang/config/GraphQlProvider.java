package com.nugurang.nugurang;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.nugurang.graphql.Mutation;
import com.nugurang.graphql.Query;
import graphql.GraphQL;
//import graphql.kickstart.tools.SchemaParser;
//import graphql.kickstart.tools.SchemaParserOptions;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.IOException;
import java.net.URL;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GraphQlProvider {
    private GraphQL graphQL;
    private final Query query;
    private final Mutation mutation;

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();

        /*
        SchemaParserOptions schemaParserOptions = SchemaParserOptions.newOptions()
            .preferGraphQLResolver(true)
            .build();

        GraphQLSchema graphQLSchema = SchemaParser.newParser()
            .options(schemaParserOptions)
            .file("schema.graphqls")
            .resolvers(query, mutation)
            .scalars(ExtendedScalars.DateTime)
            .build()
            .makeExecutableSchema();
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        */
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .scalar(ExtendedScalars.DateTime)
                .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @Bean
    public GraphQLScalarType dateTime() {
        return ExtendedScalars.DateTime;
    }
}
