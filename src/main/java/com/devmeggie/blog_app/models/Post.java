package com.devmeggie.blog_app.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name ="post")
public class Post extends BaseClass{

    @Column(nullable = false,unique = true,length = 50)
    private String title;

    @Column(nullable = false,length = 5000)
    private String content;

    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comment> comment = new ArrayList<>();
}
