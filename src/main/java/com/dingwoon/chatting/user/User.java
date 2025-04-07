package com.dingwoon.chatting.user;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class User {
    private UUID id;
    private String loginId;
    private String password;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private UserStatus status;

    public void changeNickName(String nickname) {
        this.nickname = nickname != null ? nickname.trim() : "";
    }
}
