package com.eunah.projectforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
* /posts -> done
* /posts/{post-id} -> done
* /posts/search -> done
* /posts/search-hashtag -> done
* */
@RequestMapping("/posts")
@Controller
public class ArticleController {

    @GetMapping
    public String posts(ModelMap map){
        map.addAttribute("posts", List.of());
        return "posts/index";
    }
}
