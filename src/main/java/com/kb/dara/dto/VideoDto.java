package com.kb.dara.dto;

import lombok.*;

public class VideoDto {

    //영상 기본정보
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Video{    //게시글 작성을 위해서 필요한 프론트에서 받아올 변수
        private int requester;  //의뢰자
        private int provider;   //제공자
        private int categoryIdx;    //영상 카테고리
        private String link;    //영상 링크
    }

    //토론장 게시글 작성 REQUEST DTO
    @Data
    @AllArgsConstructor // 해당 클래ame, profileImage)를 받는 생성자를 생성
    @NoArgsConstructor(access = AccessLevel.PROTECTED)  // 해당 클래스의 파라미스의 모든 멤버 변수(email, password, nickName 없는 생성자를 생성, 접근제한자를 PROTECTED로 설정.
    public static class RegisterReq{    //게시글 작성을 위해서 필요한 프론트에서 받아올 변수
        private int requester;  //의뢰자
        private int categoryIdx;    //영상 카테고리
        private String link;    //영상 링크
    }

    //토론장 게시글 작성 RESPONSE DTO
    @Data
    @Builder // 빌더 클래스 자동 생성
    public static class RegisterRes{    //게시글 작성 후 성공하게 되면 게시글 작성자의 인덱스가 반환됨.
        private int requester;
    }
}
