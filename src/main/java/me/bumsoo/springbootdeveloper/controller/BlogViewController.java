package me.bumsoo.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.bumsoo.springbootdeveloper.domain.Article;
import me.bumsoo.springbootdeveloper.dto.ArticleResponse;
import me.bumsoo.springbootdeveloper.dto.ArticleViewResponse;
import me.bumsoo.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable long id, Model model){
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}


