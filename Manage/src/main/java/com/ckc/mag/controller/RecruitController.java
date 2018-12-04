package com.ckc.mag.controller;

import com.ckc.mag.bean.Msg;
import com.ckc.mag.bean.Recruit;
import com.ckc.mag.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RecruitController {

    @Autowired
    RecruitService recruitService;

    @RequestMapping("/state")
    @ResponseBody
    public Msg RecruitState(@RequestParam(value = "state", defaultValue = "") String state){

        List<Recruit> states = recruitService.select();
        return Msg.success().add("recruit",states);
    }

    @ResponseBody
    @RequestMapping(value = "/alter/{num}", method = RequestMethod.PUT)
    public Msg saveRec(Recruit recruit) {
        recruitService.alter(recruit);
        return Msg.success();
    }


}
