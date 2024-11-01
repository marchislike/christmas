package com.march.christmas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) //Enum 값인 권한들에 대해 문자열로 저장
    private Role role;

    // User와 Post는 1:N 관계
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

//    // User와 Comment는 1:N 관계
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments;

    // Role Enum 클래스
    public enum Role {
        USER,
        ADMIN
    }

}
