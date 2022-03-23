package cn.zjf.online_xd.service.impl;

import cn.zjf.online_xd.config.CacheKeyManager;
import cn.zjf.online_xd.model.entity.Video;
import cn.zjf.online_xd.model.entity.VideoBanner;
import cn.zjf.online_xd.mapper.VideoMapper;
import cn.zjf.online_xd.service.VideoService;
import cn.zjf.online_xd.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author OneBird
 * @date 2022/3/18 15:36
 **/
@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {
        try{
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEO_LIST,()->{
                List<Video> videoList = videoMapper.listVideo();
                return videoList;
            });
            if (cacheObj instanceof List){
                List<Video> videoList = (List<Video>) cacheObj;
                return videoList;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<VideoBanner> listVideoBanner() {
        try{
            Object cacheObj =
                    baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
                        List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                        System.out.println("从数据库⾥⾯找轮播图列表");
                        return bannerList;
                    });
            if(cacheObj instanceof List){
                List<VideoBanner> bannerList = (List<VideoBanner>)cacheObj;
                return bannerList;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
//        return videoMapper.listVideoBanner();
    }

    @Override
    public Video findDetailById(int videoId) {
//单独构建一个缓存key，每个视频的key是不一样的
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL,videoId);

        try{

            Object cacheObject = baseCache.getOneHourCache().get( videoCacheKey, ()->{

                // 需要使用mybaits关联复杂查询
                Video video = videoMapper.findDetailById(videoId);

                return video;

            });

            if(cacheObject instanceof Video){

                Video video = (Video)cacheObject;
                return video;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }
}
