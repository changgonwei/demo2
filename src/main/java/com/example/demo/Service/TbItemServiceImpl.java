package com.example.demo.Service;


import com.example.demo.commons.Result;

import com.example.demo.dao.TbItemMapper;
import com.example.demo.entity.TbItem;
import com.example.demo.entity.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbItemServiceImpl implements TbItemService {
    @Autowired
    TbItemMapper tbItemMapper;
    public TbItem queryTitle(Long id){
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public String queryList(Long id) {
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria=example.createCriteria();
        criteria.andIdEqualTo(id);
        try {
            List<TbItem> list = tbItemMapper.selectByExample(example);
            if(list.isEmpty()){
                return "aa";
            }else{
                return list.get(0).getTitle();
            }
        }catch(Exception e) {
           return e.getMessage();
        }

    }

    @Override
    public Result addUser(TbItem tbItem) {
        tbItemMapper.insert(tbItem);
        return null;
    }
}
