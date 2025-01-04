package me.bumsoo.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.bumsoo.springbootdeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){
        return Article.builder().title(title).content(content).build();
    }

}
