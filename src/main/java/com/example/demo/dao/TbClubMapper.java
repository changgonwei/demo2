package com.example.demo.dao;

import com.example.demo.entity.TbClub;
import com.example.demo.entity.TbClubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbClubMapper {
    int countByExample(TbClubExample example);

    int deleteByExample(TbClubExample example);

    int deleteByPrimaryKey(Integer clubId);

    int insert(TbClub record);

    int insertSelective(TbClub record);

    List<TbClub> selectByExample(TbClubExample example);

    TbClub selectByPrimaryKey(Integer clubId);

    int updateByExampleSelective(@Param("record") TbClub record, @Param("example") TbClubExample example);

    int updateByExample(@Param("record") TbClub record, @Param("example") TbClubExample example);

    int updateByPrimaryKeySelective(TbClub record);

    int updateByPrimaryKey(TbClub record);
}