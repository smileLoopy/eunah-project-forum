package com.eunah.projectforum.repository;

import com.eunah.projectforum.config.JpaConfig;
import com.eunah.projectforum.domain.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA connection test")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    public JpaRepositoryTest(
            @Autowired PostRepository postRepository,
            @Autowired PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
    }

    @DisplayName("select test")
    @Test
    void givenTestData_whenSelecting_thenWorksFine(){

        // Given

        // When
        List<Post> posts = postRepository.findAll();

        // Then
        assertThat(posts)
                .isNotNull()
                .hasSize(123);

    }


    @DisplayName("insert test")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){

        // Given
        long previousCount = postRepository.count();

        // When
        Post savedPost = postRepository.save(Post.of("new post", "new content", "#spring"));

        // Then
        assertThat(postRepository.count()).isEqualTo(previousCount + 1);

    }

    @DisplayName("update test")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        // Given
        Post post = postRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        post.setHashtag(updatedHashtag);

        // When
        Post savedPost = postRepository.saveAndFlush(post);

        // Then
        assertThat(savedPost).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
    }


    @DisplayName("delete test")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){

        // Given
        Post post = postRepository.findById(1L).orElseThrow();
        long previousPostCount = postRepository.count();
        long previousPostCommentCount = postCommentRepository.count();
        int deletedCommentsSize = post.getPostComments().size();

        // When
        postRepository.delete(post);

        // Then
        assertThat(postRepository.count()).isEqualTo(previousPostCount - 1);
        assertThat(postCommentRepository.count()).isEqualTo(previousPostCommentCount - deletedCommentsSize);

    }

}