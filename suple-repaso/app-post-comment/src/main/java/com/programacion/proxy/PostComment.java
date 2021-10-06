package com.programacion.proxy;

import com.programacion.db.Comment;
import com.programacion.db.Post;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface PostComment {

    @GET
    @Path("/posts")
    @Produces(MediaType.APPLICATION_JSON)
    List<Post> listarPost();

    @GET
    @Path("/posts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Post listarPostId(@PathParam("id") Integer id);

    @GET
    @Path("/comments")
    @Produces(MediaType.APPLICATION_JSON)
    List<Comment> listarComments();

    @GET
    @Path("/comments/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Comment listarCommentsId(@PathParam("id") Integer id);

}
