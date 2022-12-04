package com.devmeggie.blog_app.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Comment extends BaseClass {
    @Column(length = 5000)
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name ="post_id",referencedColumnName = "id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id_id")
    private User userId;
}
