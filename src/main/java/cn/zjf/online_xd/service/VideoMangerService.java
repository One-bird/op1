package cn.zjf.online_xd.service;

import cn.zjf.online_xd.model.entity.Video;
import cn.zjf.online_xd.model.request.AdminVideoOrder;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/23 21:53
 **/
public interface VideoMangerService {
    /**
     * 修改商品信息
     * @param video
     * @return
     */
    int changVideo(Video video);

    /**
     * 展示所有订单信息
     * @return
     */
    List<AdminVideoOrder> videoOrderList();

    /**
     * 添加商品接口
     * @param video
     * @return
     */
    int addVideo(Video video);

    /**
     * 查询所有用户
     * @return
     */
    List<Video> selectAllVideo();
}
