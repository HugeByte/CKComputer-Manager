package com.ckc.mag.dao;

import com.ckc.mag.bean.Outlay;
import com.ckc.mag.bean.OutlayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutlayMapper {
    long countByExample(OutlayExample example);

    int deleteByExample(OutlayExample example);

    int deleteByPrimaryKey(String num);

    int insert(Outlay record);

    int insertSelective(Outlay record);

    List<Outlay> selectByExample(OutlayExample example);

    Outlay selectByPrimaryKey(String num);

    int updateByExampleSelective(@Param("record") Outlay record, @Param("example") OutlayExample example);

    int updateByExample(@Param("record") Outlay record, @Param("example") OutlayExample example);

    int updateByPrimaryKeySelective(Outlay record);

    int updateByPrimaryKey(Outlay record);
}