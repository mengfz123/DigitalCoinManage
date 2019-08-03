package com.ivan.digitalCoinInvest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @创建人：WUHUI
 * @创建时间：2019-7-18
 * @描述：
 **/
@Controller
public class okexController {

    @RequestMapping("/home")
    public String home(){

        return "home";
    }


}
