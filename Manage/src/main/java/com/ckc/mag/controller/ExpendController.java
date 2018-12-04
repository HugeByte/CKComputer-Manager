package com.ckc.mag.controller;

import com.ckc.mag.bean.Expend;
import com.ckc.mag.bean.Msg;
import com.ckc.mag.service.ExpendService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExpendController {

    @Autowired
    ExpendService expendService;

    @ResponseBody
    @RequestMapping(value="/exp/{ids}", method = RequestMethod.DELETE)
    public Msg deleteExp(@PathVariable("ids")String ids){
        if (ids.contains("-")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
          expendService.deleteBatch(del_ids);
        } else {
            Integer id = Integer.parseInt(ids);
           expendService.deleteExp(id);
        }
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/exp/{expid}", method = RequestMethod.PUT)
    public Msg saveExp(Expend expend) {
        expendService.updateExp(expend);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/exp/{expid}", method = RequestMethod.GET)
    public Msg getEmp(@PathVariable("expid") Integer expid) {
        Expend expend =expendService.getExp(expid);
        return Msg.success().add("exp", expend);
    }

    @RequestMapping(value = "/exp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Expend expend, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            expendService.saveExp(expend);
            return Msg.success();
        }
    }

    @RequestMapping("/searchexp")
    @ResponseBody
    public Msg selectByItem(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "item",defaultValue = "") String item) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Expend> exps = expendService.selectByItem(item);
        PageInfo page = new PageInfo(exps, 10);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/exps")
    @ResponseBody
    public Msg getExpsWithJson(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        //引入PageHelper分页插件
        //查询前只需调用,传入页码,以及分页大小
        PageHelper.startPage(pageNumber, pageSize);
        List<Expend> exps =expendService.getAll();
        ;
        //之后分页查询
        PageInfo page = new PageInfo(exps, 10);
        return Msg.success().add("pageInfo", page);
        //使用PageInfo包装查询后的结果
        //封装了详细的分页信息,包括查询的数据,连续显示的页数
    }
}
