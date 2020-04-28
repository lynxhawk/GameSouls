package com.lynx.springsouls.controller;

import com.lynx.springsouls.entity.User;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index() {
        return "hello,lynx!" + new Date();
    }

    //注册用户
    @PostMapping("/signin")
    public boolean signin(String username, String email, String password) {
        String sql = "select count(username) from user where username=?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
        if (count >= 1)
            return false;
        else {
            String sql1 = "select count(email) from user where email=?";
            int count1 = jdbcTemplate.queryForObject(sql, new Object[]{email}, Integer.class);
            if (count1 >= 1) {
                return false;
            } else {
                String sql2 = "insert into user (username,password,email) values(?,?,?)";
                jdbcTemplate.update(sql2, username, password, email);
                return true;
            }
        }
    }

    //验证用户名和密码
    @GetMapping("/login")
    public boolean login(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, new BeanPropertyRowMapper<User>(User.class));
        if (user == null)
            return false;
        else
            return true;
    }

    //登录后获取用户信息
    @GetMapping("/getuserinfo/{username}")
    public List<Map<String, Object>> queryUsers(@PathVariable String username) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user where username=?", username);
        return list;
    }

    //更新头像
    @PostMapping("/updateavatar/{id}")
    @ResponseBody
    public void updateavatar(@PathVariable int id, String avatar) {
        String sql = "update user set avatar=? where id=?";
        jdbcTemplate.update(sql, avatar, id);
    }

    //更改用户名
    @GetMapping("/updateusername/{id}")
    public boolean updateusername(@PathVariable int id, String username) {
        String sql = "select count(username) from user where username =?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
        if (count >= 1)
            return false;
        else {
            String sql1 = "update user set username=? where id=?";
            jdbcTemplate.update(sql1, username, id);
            return true;
        }
    }

    //更改邮箱
    @GetMapping("/updateemail/{id}")
    public boolean updateemail(@PathVariable int id, String email) {
        String sql = "select count(email) from user where email =?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{email}, Integer.class);
        if (count >= 1)
            return false;
        else {
            String sql1 = "update user set email=? where id=?";
            jdbcTemplate.update(sql1, email, id);
            return true;
        }
    }

    //更改游戏类型
    @PostMapping("/updategametype/{id}")
    @ResponseBody
    public void updategametype(@PathVariable int id, String gametype) {
        String sql = "update user set gametype=? where id=?";
        jdbcTemplate.update(sql, gametype, id);
    }

    //更改密码
    @GetMapping("/updatepassword/{id}")
    public boolean updatepassword(@PathVariable int id, String password1, String password2) {
        String sql = "select password from user where id = ?";
        String password = jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
        if (password != password1)
            return false;
        else {
            String sql1 = "update user set password=? where id=?";
            jdbcTemplate.update(sql1, password2, id);
            return true;
        }
    }

    //更改游戏背景
    @PostMapping("/updatebackground/{id}")
    @ResponseBody
    public void updatebackground(@PathVariable int id, String background) {
        String sql = "update user set background=? where id=?";
        jdbcTemplate.update(sql, background, id);
    }

    //获取用户权限列表
    @GetMapping("/getpower")
    public List<Map<String, Object>> getpower(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user where power!=1");
        return list;
    }

    //更改用户权限
    @GetMapping("/updatepower")
    public boolean updatepower(String username,int power) {
        String sql = "update user set power=? where username=?";
        jdbcTemplate.update(sql,power,username);
        return true;
    }
}
    //http://localhost:8888/createTable
//    @GetMapping("createTable")
//    public String createTable(){
//        String sql = "CREATE TABLE `user` (\n" +
//                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
//                "  `user_name` varchar(255) DEFAULT NULL,\n" +
//                "  `pass_word` varchar(255) DEFAULT NULL,\n" +
//                "  PRIMARY KEY (`id`)\n" +
//                ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;\n" +
//                "\n";
//        jdbcTemplate.execute(sql);
//        return "创建User表成功";
//    }
//
//    //http://localhost:8888/saveUserSql
//    @GetMapping("saveUserSql")
//    public String saveUserSql(){
//        String sql = "INSERT INTO USER (USER_NAME,PASS_WORD) VALUES ('dalaoyang','123')";
//        int rows= jdbcTemplate.update(sql);
//        return "执行成功，影响"+rows+"行";
//    }
//
//    //http://localhost:8888/saveUser?userName=lisi&passWord=111
//    @GetMapping("saveUser")
//    public String saveUser(String userName,String passWord){
//        int rows= jdbcTemplate.update("INSERT INTO USER (USER_NAME,PASS_WORD) VALUES (?,?)",userName,passWord);
//        return "执行成功，影响"+rows+"行";
//    }
//
//    //http://localhost:8888/updateUserPassword?id=1&passWord=111
//    @GetMapping("updateUserPassword")
//    public String updateUserPassword(int id,String passWord){
//        int rows= jdbcTemplate.update("UPDATE USER SET PASS_WORD = ? WHERE ID = ?",passWord,id);
//        return "执行成功，影响"+rows+"行";
//    }
//
//    //http://localhost:8888/deleteUserById?id=1
//    @GetMapping("deleteUserById")
//    public String deleteUserById(int id){
//        int rows= jdbcTemplate.update("DELETE FROM  USER  WHERE ID = ?",id);
//        return "执行成功，影响"+rows+"行";
//    }
//
//
//    //http://localhost:8888/batchSaveUserSql
//    @GetMapping("batchSaveUserSql")
//    public String batchSaveUserSql(){
//        String sql =
//                "INSERT INTO USER (USER_NAME,PASS_WORD) VALUES (?,?)" ;
//        List<Object[]> paramList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            String[] arr = new String[2];
//            arr[0] = "zhangsan"+i;
//            arr[1] = "password"+i;
//            paramList.add(arr);
//        }
//        jdbcTemplate.batchUpdate(sql,paramList);
//        return "执行成功";
//    }
//
//    //http://localhost:8888/getUserByUserName?userName=zhangsan0
//    //@GetMapping("getUserByUserName")
//    //public List getUserByUserName(String userName){
//    //    String sql = "SELECT * FROM USER WHERE USER_NAME = ?";
//        //写法很多种
//        //下面列举两种写法，都可以实现
//        //List<User> list= jdbcTemplate.query(sql,new Object[]{userName}, new BeanPropertyRowMapper(User.class));
//        //List<User> list= jdbcTemplate.query(sql,new User(),new Object[]{userName});
//
//    //    return list;
//    //}
//
//    //http://localhost:8888/getMapById?id=1
//    @GetMapping("getMapById")
//    public Map getMapById(Integer id){
//        String sql = "SELECT * FROM USER WHERE ID = ?";
//        Map map= jdbcTemplate.queryForMap(sql,id);
//        return map;
//    }
//
//    //http://localhost:8888/getUserById?id=1
//    @GetMapping("getUserById")
//    public User getUserById(Integer id){
//        String sql = "SELECT * FROM USER WHERE ID = ?";
//        User user = new User();//= jdbcTemplate.queryForObject(sql,new User(),new Object[]{id});
//        return user;
//    }

