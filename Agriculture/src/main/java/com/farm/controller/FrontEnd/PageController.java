package com.farm.controller.FrontEnd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Rain
 * @Description: 控制页面跳转
 * @Date: Created on 2018/10/31 18:49
 */
@Controller
public class PageController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/device")
    public String device() {
        return "/device";
    }

    @RequestMapping("videomonitor")
    public String monitor() {
        return "/videomonitor";
    }

    @RequestMapping("controller")
    public String controllerPage() {
        return "/controller";
    }
    @RequestMapping("controller1")
    public String controllerPage1() {
        return "/controller1";
    }
    @RequestMapping("controller2")
    public String controllerPage2() {
        return "/controller2";
    }
    @RequestMapping("controller3")
    public String controllerPage3() {
        return "/controller3";
    }
    @RequestMapping("controller4")
    public String controllerPage4() {
        return "/controller4";
    }
    @RequestMapping("controller5")
    public String controllerPage5() {
        return "/controller5";
    }
    @RequestMapping("controller6")
    public String controllerPage6() {
        return "/controller6";
    }
    @RequestMapping("controller7")
    public String controllerPage7() {
        return "/controller7";
    }
    @RequestMapping("controller8")
    public String controllerPage8() {
        return "/controller8";
    }
    @RequestMapping("controller9")
    public String controllerPage9() {
        return "/controller9";
    }
    @RequestMapping("controller10")
    public String controllerPage10() {
        return "/controller10";
    }
    @RequestMapping("controller11")
    public String controllerPage11() {
        return "/controller11";
    }
    @RequestMapping("controller12")
    public String controllerPage12() {
        return "/controller12";
    }
    @RequestMapping("controller13")
    public String controllerPage13() {
        return "/controller13";
    }
    @RequestMapping("controller14")
    public String controllerPage14() {
        return "/controller14";
    }
    @RequestMapping("controller15")
    public String controllerPage15() {
        return "/controller15";
    }
    @RequestMapping("controller16")
    public String controllerPage16() {
        return "/controller16";
    }

}
