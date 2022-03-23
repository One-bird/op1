package cn.zjf.online_xd.mapper;

import cn.zjf.online_xd.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

/**
 * @author OneBird
 * @date 2022/3/20 9:01
 **/
public interface EpisodeMapper {
    /**
     * 查询第一个播放记录
     * @param videoId
     * @return
     */
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
