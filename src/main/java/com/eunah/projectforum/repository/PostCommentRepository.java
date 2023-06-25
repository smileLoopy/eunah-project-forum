package com.eunah.projectforum.repository;

import com.eunah.projectforum.domain.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PostCommentRepository extends JpaRepository<PostComment,Long> {
}
