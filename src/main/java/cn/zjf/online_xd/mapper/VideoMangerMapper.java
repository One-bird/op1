package cn.zjf.online_xd.mapper;

import cn.zjf.online_xd.model.entity.Video;
import cn.zjf.online_xd.model.request.AdminVideoOrder;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/23 22:00
 **/

public interface VideoMangerMapper {
    /**
     * 修改商品信息
     * @param video
     * @return
     */
    int changVideo(Video video);

    /**
     * 显示用户订单信息
     * @return
     */
    List<AdminVideoOrder> videoOrderList();

    /**
     * 添加商品
     * @param video
     * @return
     */
    int addVideo(Video video);

    /**
     * 查询所有用户
     * @return
     */
    List<Video> selectAllUser();
}
