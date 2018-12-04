package com.ckc.mag.service;

import com.ckc.mag.bean.Member;
import com.ckc.mag.bean.MemberExample;
import com.ckc.mag.dao.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    /*查询所有正式社员*/
    public List<Member> getAll() {
        return memberMapper.selectByPayAndPic(null);
    }

    /*查询所有正式社员与非正式社员*/
    public List<Member> selectAll(){return memberMapper.selectByExample(null);}


    /*多条件联合查询*/
    public  List<Member> selectByName(String Name,String Pay,String Pic){
        MemberExample example= new MemberExample();
        MemberExample.Criteria criteria =example.createCriteria();
        criteria.andNameEqualTo(Name);
        List<Member> members=memberMapper.selectByName(Name,Pay,Pic);
        return  members;

    }

    public void saveEmp(Member member) {
        memberMapper.insertSelective(member);
    }

    public boolean checkUser(String Name) {
        MemberExample example= new MemberExample();
        MemberExample.Criteria criteria =example.createCriteria();
        criteria.andNameEqualTo(Name);
        long count=memberMapper.countByExample(example);
        return count==0;
    }

    public Member getEmp(Integer memid) {
        Member member=memberMapper.selectByPrimaryKey(memid);
        return member;
    }

    public void updateEmp(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }

    public void deleteEmp(Integer memid) {
        memberMapper.deleteByPrimaryKey(memid);
    }

    public void deleteBatch(List<Integer> ids) {
        MemberExample example = new MemberExample();
        MemberExample.Criteria criteria=example.createCriteria();
        criteria.andMemidIn(ids);
        memberMapper.deleteByExample(example);
    }
}
