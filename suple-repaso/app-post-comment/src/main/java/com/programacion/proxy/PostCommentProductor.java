package com.programacion.proxy;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.net.URI;

@RequestScoped
public class PostCommentProductor {

    @Inject
    @ConfigProperty(name = "post.comment.url", defaultValue = "https://jsonplaceholder.typicode.com")
    private String url;

    @RequestScoped
    @Produces
    public PostComment create(){
        PostComment servicio = RestClientBuilder.newBuilder()
                .baseUri(URI.create(url))
                .build(PostComment.class);
        return servicio;
    }

}
