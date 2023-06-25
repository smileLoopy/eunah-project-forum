package com.eunah.projectforum.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View Controller - Post")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {
    private  final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] post list (forum) page - normal call")
    @Test
    public void givenNothing_whenRequestingPostsView_thenReturnsPostsView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("posts"));
    }

    @DisplayName("[view][GET] post detail page - normal call")
    @Test
    public void givenNothing_whenRequestingPostView_thenReturnsPostView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("post"));
    }

    @DisplayName("[view][GET] post search page - normal call")
    @Test
    public void givenNothing_whenRequestingPostSearchView_thenReturnsPostSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/posts/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

    @DisplayName("[view][GET] post hashtag search page - normal call")
    @Test
    public void givenNothing_whenRequestingPostHashtagSearchView_thenReturnsPostHashtagSearchView() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/posts/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
}
