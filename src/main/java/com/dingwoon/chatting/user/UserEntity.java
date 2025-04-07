package com.dingwoon.chatting.user;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_tbl")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false, length=15)
    private String loginId;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, unique = true, length = 10)
    private String nickname;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public User toModel() {
        return User.builder()
                .id(this.id)
                .loginId(this.loginId)
                .password(this.password)
                .nickname(this.nickname)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .deletedAt(this.deletedAt)
                .status(this.status)
                .build();
    }

    public UserEntity of(User user) {
        UserEntity entity = new UserEntity();
        entity.id = user.getId();
        entity.loginId = user.getLoginId();
        entity.password = user.getPassword();
        entity.nickname = user.getNickname();
        entity.createdAt = user.getCreatedAt();
        entity.updatedAt = user.getUpdatedAt();
        entity.deletedAt = user.getDeletedAt();
        entity.status = user.getStatus();
        return entity;
    }
}
