package cn.zjf.online_xd.mapper;

import cn.zjf.online_xd.model.entity.PlayRecord;

/**
 * @author OneBird
 * @date 2022/3/20 9:18
 **/
public interface PlayRecordMapper {
    /**
     * 保存视频记录
     * @param playRecord
     * @return
     */
    int saveRecord(PlayRecord playRecord);
}
