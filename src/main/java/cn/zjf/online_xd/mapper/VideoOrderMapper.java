package cn.zjf.online_xd.mapper;

import cn.zjf.online_xd.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/19 21:35
 **/
public interface VideoOrderMapper {
    /**
     * 查询用户是否购买过此商品
     * @param userId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);


    /**
     * 下单
     * @return
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * 查询用户视频订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(@Param("user_id") Integer userId);
}
