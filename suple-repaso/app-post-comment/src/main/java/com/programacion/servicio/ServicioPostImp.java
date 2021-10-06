package com.programacion.servicio;

import com.programacion.db.Post;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ServicioPostImp implements ServicioPost{

    @Inject
    @Named("test")
    private DataSource dataSource;

    @Override
    public List<Post> listar(){
        List<Post> todos = new ArrayList<>();
        //final StringBuilder sb = new StringBuilder();
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM post");
             ResultSet rs = ps.executeQuery()) {
            while( rs.next() ) {
                Post p = new Post();
                p.setUserId( rs.getInt(1));
                p.setId( rs.getInt(2) );
                p.setTitle( rs.getString(3));
                p.setBody( rs.getString(4));
                todos.add(p);
            }
        }
        catch( SQLException ex )
        {
            ex.printStackTrace();
        }
        return todos;
    }


}
