package com.programacion.servicio;

import com.programacion.db.Post;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ServicioPost {

    List<Post> listar();

}
