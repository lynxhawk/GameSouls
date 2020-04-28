package com.lynx.springsouls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //显示用户发表文章列表
    @GetMapping("/getuserarticlelist/{userid}")
    public List<Map<String, Object>> querybyuser(@PathVariable int userid){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from article where userid=? order by id desc",userid);
        return list;
    }

    //显示文章发表具体内容
    @GetMapping("/getarticleinfo/{id}")
    public List<Map<String, Object>> querybyid(@PathVariable int id){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from article where id=?",id);
        return list;
    }

    //显示文章列表
    @GetMapping("/getarticlelist")
    public List<Map<String, Object>> querylist(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from article order by id desc");
        return list;
    }
    //显示关注的人发表的文章列表
    @GetMapping("/getarticleuserlist/{id}")
    public List<Map<String, Object>> queryuserlist(@PathVariable int id){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from article where userid in \n" +
                "(select followid from follow where userid =?) order by id desc",id);
        return list;
    }
    //主页显示前15条文章内容
    @GetMapping("/getarticleindex")
    public List<Map<String, Object>> queryindex(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select top(15) * from article order by id desc");
        return list;
    }
    //搜索文章标题和副标题内容
    @GetMapping("/getarticlesearch/{keyword}")
    public List<Map<String, Object>> querysearch(@PathVariable String keyword){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from article where title like concat('%',?,'%') or subtitle like concat('%',?,'%')",keyword,keyword);
        return list;
    }
    //上传文章内容
//    @PostMapping("/insertarticle")
//    @ResponseBody
//    public void  insertarticle(){
//        String sql = "";
//        jdbcTemplate.update();
//    }


}
