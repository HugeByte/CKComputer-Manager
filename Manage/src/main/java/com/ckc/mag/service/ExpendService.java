package com.ckc.mag.service;

import com.ckc.mag.bean.Expend;
import com.ckc.mag.bean.ExpendExample;
import com.ckc.mag.dao.ExpendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpendService {

    @Autowired
    ExpendMapper expendMapper;

    public List<Expend> getAll(){
        return expendMapper.selectByExample(null);
    }

    public List<Expend> selectByItem(String item){
        ExpendExample example=new ExpendExample();
        ExpendExample.Criteria criteria=example.createCriteria();
        criteria.andItemEqualTo(item);
        List<Expend> expends=expendMapper.selectByItem(item);
        return expends;
    }

    public void saveExp(Expend expend){
        expendMapper.insertSelective(expend);
    }

    public Expend getExp(Integer expid){
        Expend expend=expendMapper.selectByPrimaryKey(expid);
        return expend;
    }

    public void updateExp(Expend expend){
        expendMapper.updateByPrimaryKeySelective(expend);
    }

    public void deleteExp(Integer expid){
        expendMapper.deleteByPrimaryKey(expid);
    }

    public void deleteBatch(List<Integer> ids) {
        ExpendExample example = new ExpendExample();
        ExpendExample.Criteria criteria=example.createCriteria();
        criteria.andExpidIn(ids);
        expendMapper.deleteByExample(example);
    }
}
