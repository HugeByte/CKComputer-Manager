package com.ckc.mag.service;

import com.ckc.mag.bean.Outlay;
import com.ckc.mag.dao.OutlayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutlayService {
    @Autowired
    OutlayMapper outlayMapper;

    public List<Outlay> select(){
        return outlayMapper.selectByExample(null);
    }

    public void alter(Outlay outlay) { outlayMapper.updateByPrimaryKeySelective(outlay);
    }
}
