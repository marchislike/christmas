package com.march.christmas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data //toBuilder()메서드 자동으로 생성하려면 @Builder와 함께 필요
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    //Post와 User 간 N:1관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    // Post와 Comment는 1:N 관계입니다.
//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments;

    // 자동으로 생성 및 수정 시간 추적 - entity가 저장되기 전이나 업데이트 직전에 호출되는 메서드 지정
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    //toBuilder() 에러로 임시 추가
    // 복사 생성자 추가
    public Post(Post other) {
        this.id = other.id;
        this.title = other.title;
        this.content = other.content;
    }

}
