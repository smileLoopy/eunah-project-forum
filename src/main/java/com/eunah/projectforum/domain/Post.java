package com.eunah.projectforum.domain;

import java.time.LocalDateTime;

public class Post {
    private  Long id;
    private  String title;
    private String content;
    private  String hashtag;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

}
