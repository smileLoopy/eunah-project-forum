package com.eunah.projectforum.repository;

import com.eunah.projectforum.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}