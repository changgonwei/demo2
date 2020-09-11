package com.example.demo.Service;

import com.example.demo.commons.Result;
import com.example.demo.dao.TbUserMapper;
import com.example.demo.entity.TbUser;
import com.example.demo.entity.TbUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    TbUserMapper tbUserMapper;
    @Override
    public Result addTbUser(TbUser tbUser) {

        int i=tbUserMapper.insert(tbUser);
        if(i>0){
            return new Result(true,200,"注册成功");
        }
        return new Result(false,100,"注册失败");
    }

    @Override
    public Result queryTbUser(String username) {
        TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> list = tbUserMapper.selectByExample(example);
        if(list.size()>0){
            return new Result(false,100,"用户名已存在");
        }else {
            return new Result(true, 200, "没有用户");
        }
    }
}
