package com.example.demo.Controller;

import com.example.demo.Service.TaotaoService;
import com.example.demo.Service.TbItemService;
import com.example.demo.Service.TbUserService;
import com.example.demo.Service.TeamService;
import com.example.demo.commons.MailUtil;
import com.example.demo.commons.Result;
import com.example.demo.commons.TimeUtil;

import com.example.demo.dao.TbItemMapper;
import com.example.demo.dao.model.selectModel;
import com.example.demo.entity.TbClub;
import com.example.demo.entity.TbItem;
import com.example.demo.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class Mycontroller {



    @Autowired
    TbItemMapper tbItemMapper;
    @Autowired
    TaotaoService taotaoService;
    @Autowired
    TbItemService tbItemService;
    @Autowired
    TbUserService tbUserService;
    @Autowired
    TeamService teamService;
    @RequestMapping("/haha")
    public String hello(){
        System.out.println("aa");
        return "haha";
    }


    @RequestMapping("/query")
    public Result query(String id){
        Long idL=Long.valueOf(id).longValue();
        Object data=tbItemService.queryTitle(idL).getTitle();
        Result result=new Result(true,200,"ok",data);


        return result;



    }
    @RequestMapping("/test")
    public void test(String id) {
        Long l = Long.valueOf(id).longValue();
        System.out.println(tbItemService.queryList(l));


    }

    @RequestMapping("/tbitem")
    public TbItem tbItem(String id){
        Long l=Long.valueOf(id).longValue();
         return tbItemService.queryTitle(l);

    }

    @RequestMapping("/registerUser")
    public Result registerUser(@RequestParam String username,@RequestParam String password) {
        System.out.println("hhhh");
        System.out.println(username);
        Result result = tbUserService.queryTbUser(username);
        if (result.getCode() == 100) {
            return result;
        } else {
            TbUser tbUser = new TbUser();
            tbUser.setUsername(username);
            tbUser.setPassword(password);
            try {
                tbUser.setCreated(TimeUtil.SECOND_FORMAT.parse(TimeUtil.SECOND_FORMAT.format(new Date())));
                tbUser.setUpdated(TimeUtil.SECOND_FORMAT.parse(TimeUtil.SECOND_FORMAT.format(new Date())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return tbUserService.addTbUser(tbUser);
        }

    }
    @RequestMapping("/sendEmail")
    public Result sendEmail(){
        String s;
        try{s=MailUtil.sendmail();}
        catch (Exception e){
            System.out.println(e.getMessage());
            return new Result(false,100,"系统故障");
        }
       return new Result<>(true, 200, "验证码发送成功", s);
    }

    @RequestMapping("/sendImg")
    public Result sendImg(@RequestParam(value="Image") MultipartFile multipartFile){
        String ext = multipartFile.getOriginalFilename();
        System.out.println(ext);
        String path=System.getProperty("user.dir")+"/src/main/resources/static/img/"+ext;
        System.out.println(path);
        File file=new File(path);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new Result(false,100,"shibai");
        }
        MultipartFile mFile;
        String s = "img/" + ext;//返回view中img显示图片的路径
        System.out.println(s);
        return new Result(true,200,"ok",s);


    }

    @RequestMapping("/send")
    public Result send(){
        System.out.println("sss");
        String a="img/3.jpg";
        return new Result(true,200,"ok",a);
    }

    @RequestMapping("/club")
    public Result club(){

        ArrayList<selectModel> select=teamService.query();


        return new Result(true,200,"ok",select);
    }

    @RequestMapping("/team")
    public Result team(String id){
        int idd=Integer.valueOf(id).intValue();
        System.out.println(idd);
        ArrayList<selectModel> select=teamService.queryTeam(idd);
        return new Result(true,200,"ok",select);
    }

    @RequestMapping("/shop")
    public Result shop(String shop){
        System.out.println(shop);
        return new Result(true,200,"ok",shop);
    }





}
