package com.kb.dara.service;

import com.kb.dara.config.BaseException;
import com.kb.dara.dto.VideoDto;
import com.kb.dara.repository.video.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.kb.dara.config.BaseResponseStatus.*;

@Slf4j
@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }


    // 영상 의뢰
    @Transactional
    public VideoDto.RegisterRes insertVideo(VideoDto.RegisterReq registerReq) throws BaseException {
        String link = registerReq.getLink();
        String tmp_content = link.replaceAll(" ", "");
        if(link.isEmpty() || tmp_content.isEmpty()) { //내용이 없는 경우 validation 처리
            throw new BaseException(EMPTY_CONTENT);
        }
        try {
            return videoRepository.insert(registerReq);
        } catch (Exception exception) { // DB에 이상이 있는 경우 에러 메시지를 보냅니다.
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
