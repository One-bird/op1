package cn.zjf.online_xd.config;

/**
 * @author OneBird
 * @date 2022/3/20 13:47
 **/
public class CacheKeyManager {
    /**
     * 轮播图缓存
     */
    public static final String INDEX_BANNER_KEY = "index:banner:list";

    /**
     * 视频列表缓存
     */
    public static final String INDEX_VIDEO_LIST = "index:video:list";

    /**
     * 视频详情缓存，%s是视频id
     */
    public static final String VIDEO_DETAIL = "video:detail:%s";
}
