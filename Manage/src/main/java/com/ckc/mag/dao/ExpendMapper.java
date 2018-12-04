package com.ckc.mag.dao;

import com.ckc.mag.bean.Expend;
import com.ckc.mag.bean.ExpendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpendMapper {
    long countByExample(ExpendExample example);

    int deleteByExample(ExpendExample example);

    int deleteByPrimaryKey(Integer expid);

    int insert(Expend record);

    int insertSelective(Expend record);

    List<Expend> selectByExample(ExpendExample example);

    List<Expend> selectByItem(@Param("item")String item);

    Expend selectByPrimaryKey(Integer expid);

    int updateByExampleSelective(@Param("record") Expend record, @Param("example") ExpendExample example);

    int updateByExample(@Param("record") Expend record, @Param("example") ExpendExample example);

    int updateByPrimaryKeySelective(Expend record);

    int updateByPrimaryKey(Expend record);
}