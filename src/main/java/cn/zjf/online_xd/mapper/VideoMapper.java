package cn.zjf.online_xd.mapper;

import cn.zjf.online_xd.model.entity.Video;
import cn.zjf.online_xd.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/18 15:29
 **/

public interface VideoMapper {
    /**
     * 查询全部视频
     * @return
     */
    List<Video> listVideo();

    /**
     * 轮播图列表
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 通过id查询章集信息
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);

    /**
     * 简单查询视频信息
     * @param videoId
     * @return
     */
    Video findById(@Param("video_id") int videoId);
}
