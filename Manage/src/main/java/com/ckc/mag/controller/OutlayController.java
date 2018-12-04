package com.ckc.mag.controller;

import com.ckc.mag.bean.Msg;
import com.ckc.mag.bean.Outlay;
import com.ckc.mag.service.OutlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OutlayController {

    @Autowired
    OutlayService outlayService;

    @RequestMapping("/outlay")
    @ResponseBody
    public Msg OutlayState(@RequestParam(value = "outlay", defaultValue = "") String outlay){
        List<Outlay> outlays = outlayService.select();
        return Msg.success().add("outlay",outlays);
    }


    @RequestMapping(value = "/alterout/{num}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg saveOut(Outlay outlay) {
        outlayService.alter(outlay);
        return Msg.success();
    }
}
