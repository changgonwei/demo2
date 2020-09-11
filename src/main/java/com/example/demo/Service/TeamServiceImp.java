package com.example.demo.Service;

import com.example.demo.dao.TbClubMapper;
import com.example.demo.dao.TbTeamMapper;
import com.example.demo.dao.model.selectModel;
import com.example.demo.entity.TbClub;
import com.example.demo.entity.TbClubExample;
import com.example.demo.entity.TbTeam;
import com.example.demo.entity.TbTeamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TeamServiceImp implements TeamService {
    @Autowired
    TbClubMapper tbClubMapper;
    @Autowired
    TbTeamMapper tbTeamMapper;
    @Override
    public ArrayList queryClub(int id) {
        TbClubExample example=new TbClubExample();
        TbClubExample.Criteria criteria = example.createCriteria();
        criteria.andClubIdEqualTo(id);
        ArrayList list = (ArrayList)tbClubMapper.selectByExample(example);
        return list;

    }




    @Override
    public ArrayList queryTbClub() {
        ArrayList a=new ArrayList();
        TbClubExample example=new TbClubExample();
        TbClubExample.Criteria criteria = example.createCriteria();
        List<TbClub> list = tbClubMapper.selectByExample(example);
        for (TbClub t:
             list) {
            a.add(t.getClubName());
        }
        return a;
    }

    @Override
    public ArrayList<selectModel> query() {
        TbClubExample example=new TbClubExample();
        TbClubExample.Criteria criteria = example.createCriteria();
        List<TbClub> list =tbClubMapper.selectByExample(example);
        Iterator<TbClub> iterator = list.iterator();
        TbClub next;
        int id;
        String text;
        ArrayList<selectModel> selectModels=new ArrayList<selectModel>();
        while (iterator.hasNext()) {
            selectModel model = new selectModel();
            next = iterator.next();
            id = next.getClubId();
            text = next.getClubName();
            model.setId(id);
            model.setText(text);
            selectModels.add(model);
        }
        return  selectModels;
    }

    @Override
    public ArrayList<selectModel> queryTeam(int id) {
        TbTeamExample example=new TbTeamExample();
        TbTeamExample.Criteria teamcriteria = example.createCriteria();
        teamcriteria.andClubIdEqualTo(id);
        List<TbTeam> tbTeamList = tbTeamMapper.selectByExample(example);
        Iterator<TbTeam> iterator = tbTeamList.iterator();
        ArrayList<selectModel> select=new ArrayList<selectModel>();
        TbTeam next;
        int iid;
        String text;
        while (iterator.hasNext()) {
            selectModel model = new selectModel();
            next = iterator.next();
            iid = next.getTeamId();
            text = next.getTeamName();
            model.setId(iid);
            model.setText(text);
            select.add(model);
        }
        return  select;
    }

}

