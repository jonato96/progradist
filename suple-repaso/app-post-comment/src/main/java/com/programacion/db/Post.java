package com.programacion.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Getter @Setter
    private Integer userId;
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private String body;


}
