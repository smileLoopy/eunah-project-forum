package com.eunah.projectforum.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Data Rest - API Test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] get post list")
    @Test
    void givenNothing_whenRequestingPosts_thenReturnsPostsJsonResponse() throws Exception {
        // Given

        // When & Then
        /*
        * WebMvcTest is a slice test, so except the controller bean it is not loading any other things -> change it to integration test -> user SpringBootTest instead
        * Use Transactional for rollback all the testing data
        * */
        mvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }


    @DisplayName("[api] get post")
    @Test
    void givenNothing_whenRequestingPost_thenReturnsPostJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/posts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] get post -> postComment list")
    @Test
    void givenNothing_whenRequestingPostCommentsFromPost_thenReturnsPostCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/posts/1/postComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] get postComment list")
    @Test
    void givenNothing_whenRequestingPostComments_thenReturnsPostCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/postComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] get postComment")
    @Test
    void givenNothing_whenRequestingPostComment_thenReturnsPostCommentsJsonResponse() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/postComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
}
