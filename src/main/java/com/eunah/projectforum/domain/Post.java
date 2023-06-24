package com.eunah.projectforum.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@Entity
public class Post extends AuditingFields{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;


    @Setter @Column(nullable = false) private  String title;
    @Setter @Column(nullable = false, length = 10000) private String content;
    // default is nullable so no need to set column nullable true
    @Setter private  String hashtag;

    //Relationship mapping
    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private final Set<PostComment> postComments = new LinkedHashSet<>();

    protected Post() {}
    private Post(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }
    public static Post of(String title, String content, String hashtag) {
        return new Post(title, content, hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return id != null && id.equals(post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
