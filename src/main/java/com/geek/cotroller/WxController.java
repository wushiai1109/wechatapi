package com.geek.cotroller;

import com.geek.domain.Event;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.geek.utils.WxgzhUtil.httpsRequest;

/**
 * @author Wushiai
 * @date 2020/4/20 8:30
 * @content
 */
@RestController
@RequestMapping("/wxController")
public class WxController {

    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestParam("code") String code) {
        //获取用户的openid
        String appid = "wx330f134a794c9e6c";//这里填写自己的appid和secret
        String secret = "c051e309d90b3a0203f2aba170259171";//这里填写自己的appid和secret
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        System.out.println(requestUrl);
        String Result = httpsRequest(requestUrl, "GET", null);
        JSONObject jsonObject = JSONObject.fromObject(Result);
        System.out.println(jsonObject);
        return jsonObject.toString();
    }

}