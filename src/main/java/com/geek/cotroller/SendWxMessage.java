//package com.geek.cotroller;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.geek.domain.Event;
//import com.geek.domain.TemplateData;
//import com.geek.domain.WxMssVo;
//import com.geek.mapper.EventMapper;
//import com.geek.service.EventService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Wushiai
// * @date 2020/4/19 1:06
// * @content
// */
//@RestController
//public class SendWxMessage {
//
//    @Autowired
//    EventMapper eventMapper;
//
//    private ResponseEntity<String> responseEntity;
//
//    /*
//     * 发送订阅消息
//     * */
//    @GetMapping("/send")
//    public String send(@RequestParam("openid") String openid, @RequestParam("date") String date, @RequestParam("msg") String msg) {
//        System.out.println("sendopenid:" + openid);
//        System.out.println("senddate:" + date);
//        System.out.println("sendmsg:" + msg);
////        return getOpenId(code, date);
//        return push(openid, date, msg);
//    }
//
//    public String push(String openid, String date, String msg) {
//
//        Event event = new Event();
//        event.setOpenid(openid);
//        event.setDate(date);
//        event.setMsg(msg);
//        eventMapper.insertUserInfo(event);
//
//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//设置当前时间的格式，为年-月-日
//                String s = dateFormat.format(new Date());
//                List<Event> list = eventMapper.selectUserInfoAll(event);
//                for (Event event1 : list) {
//                    if (event1.getDate().equals(s)) {
//                        RestTemplate restTemplate = new RestTemplate();
//                        //这里简单起见我们每次都获取最新的access_token（时间开发中，应该在access_token快过期时再重新获取）
//                        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + getAccessToken();
//                        //拼接推送的模版
//                        WxMssVo wxMssVo = new WxMssVo();
//                        wxMssVo.setTouser(openid);//用户的openid（要发送给那个用户）
//                        wxMssVo.setTemplate_id("IRL6ejNo18XId_-caU-fWK8XJ7yvOvOSiJNlP3wXXnE");//订阅消息模板id
//                        wxMssVo.setPage("pages/index/index");
//
//                        Map<String, TemplateData> m = new HashMap<>();
//                        m.put("date2", new TemplateData(event1.getDate()));
//                        m.put("thing9", new TemplateData(event1.getMsg()));
//                        wxMssVo.setData(m);
//                        responseEntity = restTemplate.postForEntity(url, wxMssVo, String.class);
//                        responseEntity.getBody();
//                        eventMapper.deleteUserInfo(event1);
//                    }
//                }
//            }
//        }, 0, 3600000, TimeUnit.MILLISECONDS);
//
////        RestTemplate restTemplate = new RestTemplate();
////        //这里简单起见我们每次都获取最新的access_token（时间开发中，应该在access_token快过期时再重新获取）
////        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + getAccessToken();
////        //拼接推送的模版
////        WxMssVo wxMssVo = new WxMssVo();
////        wxMssVo.setTouser(openid);//用户的openid（要发送给那个用户）
////        wxMssVo.setTemplate_id("IRL6ejNo18XId_-caU-fWK8XJ7yvOvOSiJNlP3wXXnE");//订阅消息模板id
////        wxMssVo.setPage("pages/index/index");
////
////        Map<String, TemplateData> m = new HashMap<>();
////        m.put("date2", new TemplateData(date));
////        m.put("thing9", new TemplateData(msg));
////        wxMssVo.setData(m);
////        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, wxMssVo, String.class);
//        return responseEntity.getBody();
//    }
//
//    @GetMapping("/getAccessToken")
//    public String getAccessToken() {
//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> params = new HashMap<>();
//        params.put("APPID", "wx330f134a794c9e6c");  //
//        params.put("APPSECRET", "c051e309d90b3a0203f2aba170259171");  //
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
//                "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={APPID}&secret={APPSECRET}", String.class, params);
//        String body = responseEntity.getBody();
//        JSONObject object = JSON.parseObject(body);
//        String Access_Token = object.getString("access_token");
//        System.out.println(Access_Token);
//        String expires_in = object.getString("expires_in");
//        System.out.println("有效时长expires_in：" + expires_in);
//        return Access_Token;
//    }
//}