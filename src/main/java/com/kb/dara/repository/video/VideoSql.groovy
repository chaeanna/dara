package com.kb.dara.repository.video

class VideoSql {

    //영상의뢰
    public static final String INSERT_VIDEO = """
        INSERT INTO Video (requester, categoryIdx, link)
        values (:requester, :categoryIdx, :link)
    """
}