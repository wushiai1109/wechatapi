package com.geek.service;

import com.geek.domain.Event;
import com.geek.domain.ResultInfo;
import com.geek.mapper.EventMapper;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wushiai
 * @date 2020/4/21 10:26
 * @content
 */
@Service
//@Transactional
public class EventService {

    @Autowired
    EventMapper eventMapper;

    public ResultInfo deleteUserInfo(Event event) {
        ResultInfo info = new ResultInfo();

        Event event1 = eventMapper.selectUserInfo(event);
        if (event1 == null) {
            info.setFlag(false);
            info.setMsg("此日期未设置日程提醒");
            return info;
        }
        eventMapper.deleteUserInfo(event);

        info.setFlag(true);
        info.setMsg("删除成功");
        return info;
    }

    public ResultInfo selectUserInfo(Event event) {
        ResultInfo info = new ResultInfo();
        Event event1 = eventMapper.selectUserInfo(event);
        if (event1 == null) {
            info.setFlag(false);
            info.setMsg("此日期未设置日程提醒");
            return info;
        }
        info.setFlag(true);
        return info;
    }

    public ResultInfo updateUserInfo(Event event) {
        ResultInfo info = new ResultInfo();
        eventMapper.deleteUserInfo(event);
        eventMapper.insertUserInfo(event);
        info.setFlag(true);
        info.setMsg("更新成功");
        return info;
    }

    public ResultInfo selectUserInfoAll(Event event) {
        ResultInfo info = new ResultInfo();
        List<Event> list = eventMapper.selectUserInfoAll(event);
        info.setFlag(true);
        info.setData(list);
        info.setMsg("查询成功");
        return info;
    }
}
