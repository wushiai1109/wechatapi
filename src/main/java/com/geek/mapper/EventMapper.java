package com.geek.mapper;

import com.geek.domain.Event;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wushiai
 * @date 2020/4/21 10:29
 * @content
 */
@Mapper
@Repository
public interface EventMapper {

    /**
     * 添加事件
     *
     * @param event
     */
    @Insert("insert into wechatapi_event(openid,date,msg) values(#{openid},#{date},#{msg})")
    void insertUserInfo(Event event);

    /**
     * 删除事件
     *
     * @param event
     */
    @Delete("delete from wechatapi_event where openid=#{openid} and date=#{date} and msg=#{msg}")
    void deleteUserInfo(Event event);


    /**
     * 查询当前时间事件
     * @param event
     * @return
     */
    @Select("select * from wechatapi_event where openid=#{openid} and date=#{date}")
    Event selectUserInfo(Event event);

    /**
     * 查询当前时间的所有事件
     * @param event
     * @return
     */
    @Select("select * from wechatapi_event where openid=#{openid}")
    List<Event> selectUserInfoAll(Event event);
}
