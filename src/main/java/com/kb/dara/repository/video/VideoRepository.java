package com.kb.dara.repository.video;

import com.kb.dara.dto.VideoDto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public class VideoRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    VideoSql videoSql;
    public VideoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    //영상 의뢰
    public VideoDto.RegisterRes insert(VideoDto.RegisterReq video) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("requester", video.getRequester())
                .addValue("categoryIdx", video.getCategoryIdx())
                .addValue("link", video.getLink());
        int affectedRows = namedParameterJdbcTemplate.update(videoSql.INSERT_VIDEO, parameterSource, keyHolder);
        return VideoDto.RegisterRes.builder().requester(video.getRequester()).build();
    }
}
