package com.kb.dara.controller;

import com.kb.dara.config.BaseException;
import com.kb.dara.config.BaseResponse;
import com.kb.dara.dto.VideoDto;
import com.kb.dara.repository.video.VideoRepository;
import com.kb.dara.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    VideoService videoService;
    @Autowired
    VideoRepository videoRepository;

    /*
        영상 의뢰
     */
    @PostMapping(value="/register")     //https://www.kbdara.shop/posts/register
    public BaseResponse<VideoDto.RegisterRes> createVideo(@RequestBody VideoDto.RegisterReq registerReq){   //받을 정보 입력 (dto에서 상세)
        try {
            VideoDto.RegisterRes registerRes = videoService.insertVideo(registerReq);
            return new BaseResponse<>(registerRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }

    }
}
