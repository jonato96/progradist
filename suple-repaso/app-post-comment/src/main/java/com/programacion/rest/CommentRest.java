package com.programacion.rest;

import com.programacion.db.Comment;
import com.programacion.proxy.PostComment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/comentarios")
@ApplicationScoped
public class CommentRest {

    @Inject
    private PostComment servicio;

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public String ping(){
        return "Hola desde comentarios";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> todos(){
        return servicio.listarComments();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment Uno(@PathParam("id") Integer id){
        return servicio.listarCommentsId(id);
    }

}
