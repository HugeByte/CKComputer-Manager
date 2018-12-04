package com.ckc.mag.controller;

import com.ckc.mag.bean.Member;
import com.ckc.mag.bean.Msg;
import com.ckc.mag.service.MemberService;
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
public class MemberController {

    @Autowired
    MemberService memberService;

    @ResponseBody
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            memberService.deleteBatch(del_ids);
        } else {
            Integer id = Integer.parseInt(ids);
            memberService.deleteEmp(id);
        }
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/emp/{memid}", method = RequestMethod.PUT)
    public Msg saveEmp(Member member) {
        memberService.updateEmp(member);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public Msg getEmp(@PathVariable("id") Integer id) {
        Member member = memberService.getEmp(id);
        return Msg.success().add("emp", member);
    }

    @ResponseBody
    @RequestMapping("/checkuser")
    public Msg checkuser(@RequestParam("name") String name) {
        String regx = "(^[A-Za-z0-9]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,6}$)";
        if (!name.matches(regx)) {
            return Msg.fail().add("va_msg", "用户名格式错误，请重新输入");
        }
        boolean b = memberService.checkUser(name);
        if (b) {
            return Msg.success();
        } else {
            return Msg.fail().add("va_msg", "该用户已存在");
        }
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Member member, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            memberService.saveEmp(member);
            return Msg.success();
        }
    }

    @RequestMapping("/search")
    @ResponseBody
    public Msg selectByName(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "name",defaultValue = "") String name,
                            @RequestParam(value = "pay",defaultValue = "") String pay,
                            @RequestParam(value = "pic",defaultValue = "") String pic) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Member> emps = memberService.selectByName(name,pay,pic);
        PageInfo page = new PageInfo(emps, 10);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/all")
    @ResponseBody
    public Msg selectAll(@RequestParam(value = "pageNumber",defaultValue = "1"
    ) Integer pageNumber,
                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Member> emps = memberService.selectAll();
        PageInfo page = new PageInfo(emps, 10);
        return Msg.success().add("pageInfo", page);
    }

    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        //引入PageHelper分页插件
        //查询前只需调用,传入页码,以及分页大小
        PageHelper.startPage(pageNumber, pageSize);
        List<Member> emps = memberService.getAll();
        ;
        //之后分页查询
        PageInfo page = new PageInfo(emps, 10);
        return Msg.success().add("pageInfo", page);
        //使用PageInfo包装查询后的结果
        //封装了详细的分页信息,包括查询的数据,连续显示的页数
    }


}
