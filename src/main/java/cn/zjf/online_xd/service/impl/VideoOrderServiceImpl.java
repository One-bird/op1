package cn.zjf.online_xd.service.impl;

import cn.zjf.online_xd.execption.XdException;
import cn.zjf.online_xd.mapper.EpisodeMapper;
import cn.zjf.online_xd.mapper.PlayRecordMapper;
import cn.zjf.online_xd.mapper.VideoMapper;
import cn.zjf.online_xd.mapper.VideoOrderMapper;
import cn.zjf.online_xd.model.entity.Episode;
import cn.zjf.online_xd.model.entity.PlayRecord;
import cn.zjf.online_xd.model.entity.Video;
import cn.zjf.online_xd.model.entity.VideoOrder;
import cn.zjf.online_xd.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author OneBird
 * @date 2022/3/19 21:37
 **/
@Service
public class VideoOrderServiceImpl implements VideoOrderService {
    @Autowired
    private VideoOrderMapper videoOrderMapper;


    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private EpisodeMapper episodeMapper;

    @Autowired
    private PlayRecordMapper playRecordMapper;


    /**
     * 下单操作
     * 未来版本：优惠券抵扣，风控用户检查，生成订单基础信息，生成支付信息
     *
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional()
    public int save(int userId, int videoId) {

            //判断是否已经购买
            VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);

            if (videoOrder != null) {
                return 0;
            }

            Video video = videoMapper.findById(videoId);

            VideoOrder newVideoOrder = new VideoOrder();
            newVideoOrder.setCreateTime(new Date());
            newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
            newVideoOrder.setState(1);
            newVideoOrder.setTotalFee(video.getPrice());
            newVideoOrder.setUserId(userId);

            newVideoOrder.setVideoId(videoId);
            newVideoOrder.setVideoImg(video.getCoverImg());
            newVideoOrder.setVideoTitle(video.getTitle());

            int rows = videoOrderMapper.saveOrder(newVideoOrder);


            //生成播放记录
            if (rows == 1) {
                Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
                if (episode == null) {
                    throw new XdException(-1, "视频集信息不存在，请管理员检查");
                }
                PlayRecord playRecord = new PlayRecord();
                playRecord.setCreateTime(new Date());
                playRecord.setEpisodeId(episode.getId());
                playRecord.setUserId(userId);
                playRecord.setVideoId(videoId);
                playRecord.setCurrentNum(episode.getNum());
                playRecordMapper.saveRecord(playRecord);
            }


        return rows;
    }

    /**
     * 查询用户视频订单列表
     * @param userId
     * @return
     */
    @Override
    public List<VideoOrder> listOrderByUserId(Integer userId) {
        List<VideoOrder> videoOrderList = videoOrderMapper.listOrderByUserId(userId);
        return videoOrderList;
    }
}
