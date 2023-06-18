package com.eunah.projectforum.domain;

import java.time.LocalDateTime;

public class PostComment {

    private  Long id;
    private Post post;
    private String content;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

}
