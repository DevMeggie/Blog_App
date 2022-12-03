package com.devmeggie.blog_app.dtos;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UpLoadPostDto {
    private String title;
    private String content;
    private String imageUrl;


}
