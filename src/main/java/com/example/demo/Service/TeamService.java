package com.example.demo.Service;

import com.example.demo.dao.model.selectModel;
import com.example.demo.entity.TbClub;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface TeamService {
    public ArrayList queryClub(int id);

    public ArrayList queryTbClub();
    public ArrayList<selectModel> query();
    public ArrayList<selectModel> queryTeam(int id);
}
