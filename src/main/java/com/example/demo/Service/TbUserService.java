package com.example.demo.Service;

import com.example.demo.commons.Result;
import com.example.demo.entity.TbUser;
import org.springframework.stereotype.Service;

@Service
public interface TbUserService {
    public Result addTbUser(TbUser tbUser);
    public Result queryTbUser(String username);
}
