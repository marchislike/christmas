package com.march.christmas.repository;

import com.march.christmas.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //username으로 사용자 정보 조회
    //Optional : NullPointerExcepion 방지 "NPE"
    Optional<User> findByUsername(String username);

    //username 존재 여부
    boolean existsByUsername(String username);
}
