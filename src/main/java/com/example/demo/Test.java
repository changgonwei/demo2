package com.example.demo;

import com.example.demo.Service.TbUserService;
import com.example.demo.Service.TeamService;
import com.example.demo.commons.Result;
import com.example.demo.dao.*;
import com.example.demo.Service.TbItemService;
import com.example.demo.dao.model.selectModel;
import com.example.demo.entity.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    TbUserMapper tbUserMapper;
    @Autowired
    TbUserService tbUserService;
    @Autowired
    TbItemService tbItemService;
    @Autowired
    TbItemMapper tbItemMapper;
    @Autowired
    TbClubMapper tbClubMapper;
    @Autowired
    TeamService teamService;
    @org.junit.Test
    public void test1(){
        System.out.println("a");
    }
    @org.junit.Test
    public void test2(){
        String id="605616";
        Long l=Long.valueOf(id).longValue();
        System.out.println(tbItemService.queryList(l));
    }

    @org.junit.Test
    public void test3(){
        String s;
        Long l;

        TbItem tbItem=new TbItem();
        HashMap<Long,String> hashMap=new HashMap<Long,String>();
        LinkedList<String> titleList=new LinkedList<String>();
        TbItemExample example =new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        List<TbItem> list = tbItemMapper.selectByExample(example);
        Iterator<TbItem> iterator = list.iterator();
        while (iterator.hasNext()){
            tbItem=iterator.next();
            l=tbItem.getId();
            s=tbItem.getTitle();
            hashMap.put(l,update(s));
            System.out.println(l);
            System.out.println(update(s));

        }
      Iterator<Long> iterator1 = hashMap.keySet().iterator();
        while(iterator1.hasNext()){
            l=iterator1.next();
            System.out.println(l);
            System.out.println(hashMap.get(l));
            tbItem.setId(l);
            tbItem.setSellPoint(hashMap.get(l));
            tbItemMapper.updateByPrimaryKeySelective(tbItem);

        }


    }

    public String update(String s){
    return s+"2";


    }

    @org.junit.Test
    public void test4(){
        Result result=tbUserService.queryTbUser("sdg");
        System.out.println(result.getMessage());
        System.out.println("jjjjjjjj");
    }

    @org.junit.Test
    public void test5(){
        TbUser tbUser = tbUserMapper.selectByPrimaryKey(7L);
        System.out.println(tbUser.getPhone());
    }
    @org.junit.Test
    public void  test6(){
        Resource resource=new ClassPathResource("");
        try {
            System.out.println(resource.getFile().getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    @org.junit.Test
    public void test7(){
        TbClub next;
        int id;
        String text;

        Map<Integer,String> map=new HashMap<Integer, String>();
        LinkedList<selectModel> modelLinkedList=new LinkedList<selectModel>();
        TbClubExample example=new TbClubExample();
        TbClubExample.Criteria criteria = example.createCriteria();
        List<TbClub> list =tbClubMapper.selectByExample(example);
        Iterator<TbClub> iterator = list.iterator();
        while (iterator.hasNext()) {
            selectModel model = new selectModel();
            next = iterator.next();
            id = next.getClubId();
            text = next.getClubName();
            model.setId(id);
            model.setText(text);
            modelLinkedList.add(model);
        }
//        for (int i=0;i<list.size();i++){
//            selectModel model=new selectModel();
//            id=list.get(i).getClubId();
//            model.setId(id);
//            text=list.get(i).getClubName();
//            model.setText(text);
//            modelLinkedList.add(model);
//
//
//
//
//
//
//        }
//        for(Map.Entry<Integer, String> a:map.entrySet()){
//
//            System.out.println("键是"+a.getKey());
//
//            System.out.println("值是"+a.getValue());
//
//        }
        for (selectModel m:
             modelLinkedList) {
            System.out.println(m.getId());
          System.out.println(m.getText());
        }
    }
//    @org.junit.Test
//    public void test9(){
//
//        for (selectModel m:
//             select) {
//            System.out.println(m.getId());
//            System.out.println(m.getText());
//        }
//    }
}
