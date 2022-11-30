package com.devmeggie.blog_app.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    private Long id;

    @Column(nullable = false,unique = true,length = 50)
    private String name ;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Post> post = new ArrayList<>();

}
