package cn.zjf.online_xd.service;

import cn.zjf.online_xd.model.entity.Video;
import cn.zjf.online_xd.model.entity.VideoBanner;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/18 15:35
 **/
public interface VideoService {
    List<Video> listVideo();

    List<VideoBanner> listVideoBanner();

    Video findDetailById(int videoId);
}
