package cn.zjf.online_xd.service;

import cn.zjf.online_xd.model.entity.VideoOrder;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/19 21:37
 **/
public interface VideoOrderService {
    /**
     * 保存用户下单
     * @param userId
     * @param videoId
     * @return
     */
    int save(int userId, int videoId);

    /**
     * 查询用户订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserId(Integer userId);
}
