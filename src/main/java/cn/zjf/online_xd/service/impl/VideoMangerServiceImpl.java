package cn.zjf.online_xd.service.impl;

import cn.zjf.online_xd.mapper.VideoMangerMapper;
import cn.zjf.online_xd.model.entity.Video;
import cn.zjf.online_xd.model.request.AdminVideoOrder;
import cn.zjf.online_xd.service.VideoMangerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/23 21:57
 **/
@Service
public class VideoMangerServiceImpl implements VideoMangerService {

    @Autowired
    private VideoMangerMapper videoMangerMapper;

    @Override
    public int changVideo(Video video) {
        int row = videoMangerMapper.changVideo(video);
        return row;
    }

    @Override
    public List<AdminVideoOrder> videoOrderList() {
        List<AdminVideoOrder> videoList = videoMangerMapper.videoOrderList();
        return videoList;
    }

    @Override
    public int addVideo(Video video) {
        video.setCreateTime(new Date());
        int row = videoMangerMapper.addVideo(video);
        return row;
    }

    @Override
    public List<Video> selectAllVideo() {
        List<Video> videoList = videoMangerMapper.selectAllUser();
        return videoList;
    }
}
