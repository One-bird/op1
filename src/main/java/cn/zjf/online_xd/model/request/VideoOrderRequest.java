package cn.zjf.online_xd.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author OneBird
 * @date 2022/3/19 21:39
 **/
public class VideoOrderRequest {
    @JsonProperty("video_id")
    private int videoId;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
