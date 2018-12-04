package com.ckc.mag.service;

import com.ckc.mag.bean.Recruit;
import com.ckc.mag.dao.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {

    @Autowired
    RecruitMapper recruitMapper;

    public List<Recruit> select(){
        return recruitMapper.selectByExample(null);
    }

    public void alter(Recruit recruit) { recruitMapper.updateByPrimaryKeySelective(recruit);
    }

}
