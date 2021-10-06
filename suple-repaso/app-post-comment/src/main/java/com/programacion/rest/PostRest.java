package com.programacion.rest;

import com.programacion.db.Post;
import com.programacion.proxy.PostComment;
import com.programacion.servicio.ServicioPost;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/publicaciones")
public class PostRest {

    @Inject
    private PostComment servicio;

    @Inject
    private ServicioPost srvPost;

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public String ping(){
        return "Hola desde publicaciones";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> todos(){
        return servicio.listarPost();
    }

    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> todosDs(){
        return srvPost.listar();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post uno(@PathParam("id") Integer id){
        return servicio.listarPostId(id);
    }

}
