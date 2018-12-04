package com.ckc.mag.test;

import com.ckc.mag.bean.Member;
import com.ckc.mag.dao.MemberMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {


    @Autowired
    MemberMapper memberMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public  void testCRUD(){
/*        //创建SpringIOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取mapper
        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
        System.out.println(memberMapper);

        //1.插入几个部门
/*        departmentMapper.insertSelective(new Department(null,"人事部"));
        departmentMapper.insertSelective(new Department(null,"科研部"));*/

        //2.生成员工数据，测试员工插入
        //employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@qq.com",1));
        //3.批量插入多个员工
        MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
        for(int i=0;i<500;i++){
            String uid=UUID.randomUUID().toString().substring(0,5)+i;
            String randclass=UUID.randomUUID().toString().substring(0,4)+i;
            String qq=UUID.randomUUID().toString().substring(0,9)+i;
            String phone=UUID.randomUUID().toString().substring(0,11)+i;
            String rd = String.valueOf((int) Math.floor((Math.random() * (2))));
            mapper.insertSelective(new Member(null,"测试数据"+uid,"班级"+randclass,qq,phone,rd,rd));
        }
        System.out.println("插入完成");
    }
}