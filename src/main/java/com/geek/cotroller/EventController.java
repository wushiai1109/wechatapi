package com.geek.cotroller;

import com.geek.domain.Event;
import com.geek.domain.ResultInfo;
import com.geek.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wushiai
 * @date 2020/4/21 10:28
 * @content
 */
@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    EventService eventService;

    /**
     * 删除事件
     * @param event
     * @return
     */
    @RequestMapping("/deleteUserInfo")
    public ResultInfo deleteUserInfo(@RequestBody Event event) {
        return eventService.deleteUserInfo(event);
    }

    /**
     * 查询当前时间的事件
     * @param event
     * @return
     */
    @RequestMapping("/selectUserInfo")
    public ResultInfo selectUserInfo(@RequestBody Event event) {
        return eventService.selectUserInfo(event);
    }

    /**
     * 修改当前时间
     * @param event
     * @return
     */
    @RequestMapping("/updateUserInfo")
    public ResultInfo updateUserInfo(@RequestBody Event event) {
        return eventService.updateUserInfo(event);
    }

    /**
     * 查询当前时间的事件
     * @param event
     * @return
     */
    @RequestMapping("/selectUserInfoAll")
    public ResultInfo selectUserInfoAll(@RequestBody Event event) {
        return eventService.selectUserInfoAll(event);
    }

}
