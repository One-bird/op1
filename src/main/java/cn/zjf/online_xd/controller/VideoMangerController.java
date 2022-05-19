package cn.zjf.online_xd.controller;

import cn.zjf.online_xd.model.entity.Video;
import cn.zjf.online_xd.model.request.AdminVideoOrder;
import cn.zjf.online_xd.service.VideoMangerService;
import cn.zjf.online_xd.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/23 21:52
 **/
@RestController
@RequestMapping("admin/v1/pri/video")
public class VideoMangerController {

    @Autowired
    private VideoMangerService videoMangerService;

    /**
     * 修改用户信息
     *
     * @param video
     * @return
     */
    @GetMapping("modifyInfo")
    public JsonData changVideo(@RequestBody Video video) {
        int row = videoMangerService.changVideo(video);
        if (row == 1) {
            return JsonData.buildSuccess("修改成功");
        } else {
            return JsonData.buildError("修改失败");
        }
    }

    /**
     * 查询订单列表
     *
     * @return
     */
    @GetMapping("orderList")
    public JsonData videoOrderList() {
        List<AdminVideoOrder> videoOrderList = videoMangerService.videoOrderList();
        return JsonData.buildSuccess(videoOrderList);
    }

    @GetMapping("addVideo")
    public JsonData addVideo(@RequestBody Video video) {
        int res = videoMangerService.addVideo(video);
        return res == 0 ? JsonData.buildError("添加失败") : JsonData.buildSuccess("添加成功");
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("selectVideo")
    public JsonData selectAllVideo(){
        List<Video> videoList = videoMangerService.selectAllVideo();
        return videoList == null ? JsonData.buildError("查询失败") : JsonData.buildSuccess(videoList);
    }
}
