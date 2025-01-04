package me.bumsoo.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.bumsoo.springbootdeveloper.dto.ArticleListViewResponse;
import me.bumsoo.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream().map(ArticleListViewResponse::new).toList();
        model.addAttribute("articles", articles);

        return "articleList";
    }
}
