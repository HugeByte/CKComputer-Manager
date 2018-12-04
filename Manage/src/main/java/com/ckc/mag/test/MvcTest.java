package com.ckc.mag.test;

import com.ckc.mag.bean.Member;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

//测试请求功能.测试crud正确性
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:dispatcherServlet-servlet.xml"})
public class MvcTest {
    //传入Springmvc的ioc
    @Autowired
    WebApplicationContext context;
    //虚拟mvc请求，获取到处理结果
    MockMvc mockMvc;

    @Before
    public  void initMokcMvc(){
        mockMvc=  MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void  testPage() throws Exception {
        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn","1")).andReturn();

        //请求成功后,请求域中有pageInfo，之后取出pageInfo验证
        MockHttpServletRequest request= result.getRequest();
        PageInfo pi= (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码"+pi.getPageNum());
        System.out.println("总页码"+pi.getPages());
        System.out.println("总记录数"+pi.getTotal());
        System.out.println("在页码需要连续显示的页码");
        int[] nums=pi.getNavigatepageNums();
        for (int i :nums) {
            System.out.print(" "+i);
        }
        //获取员工数据
        List<Member> list=pi.getList();
        for (Member member:list){
            System.out.println("ID:"+member.getMemid()+"==>Name:"+member.getName());
        }
        
    }
}
