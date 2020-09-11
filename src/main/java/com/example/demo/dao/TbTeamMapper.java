package com.example.demo.dao;

import com.example.demo.entity.TbTeam;
import com.example.demo.entity.TbTeamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbTeamMapper {
    int countByExample(TbTeamExample example);

    int deleteByExample(TbTeamExample example);

    int deleteByPrimaryKey(Integer teamId);

    int insert(TbTeam record);

    int insertSelective(TbTeam record);

    List<TbTeam> selectByExample(TbTeamExample example);

    TbTeam selectByPrimaryKey(Integer teamId);

    int updateByExampleSelective(@Param("record") TbTeam record, @Param("example") TbTeamExample example);

    int updateByExample(@Param("record") TbTeam record, @Param("example") TbTeamExample example);

    int updateByPrimaryKeySelective(TbTeam record);

    int updateByPrimaryKey(TbTeam record);
}