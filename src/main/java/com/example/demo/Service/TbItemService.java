package com.example.demo.Service;

import com.example.demo.commons.Result;
import com.example.demo.entity.TbItem;
import org.springframework.stereotype.Service;

@Service
public interface TbItemService {
    public TbItem queryTitle(Long id);
    public String queryList(Long id);
    public Result addUser(TbItem tbItem);

}
