package com.wecgwm.sample.mapper;

import com.wecgwm.sample.model.Entity.SampleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SampleMapper {
    @Select("select id, c, d from sample_entity where id = #{id}")
    SampleEntity selectById(@Param("id") int id);

    List<SampleEntity> selectByIdList(@Param("idList") List<Integer> idList);

}
