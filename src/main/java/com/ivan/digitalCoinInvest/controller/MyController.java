package com.ivan.digitalCoinInvest.controller;

/**
 * @创建人：WUHUI
 * @创建时间：2019-7-18
 * @描述：
 **/

import com.ivan.digitalCoinInvest.websocket.MyWebSocket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MyController {


    @ResponseBody
    @RequestMapping("/pushMsg")
    public void test(@RequestParam String msg) {

        try {

            MyWebSocket.sendInfo(msg);//发送消息到clientsocket
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/test")
    public String goTestPage(){
        return "Test";
    }

}