package com.mongodb.springbootdemo.controller;

import com.mongodb.springbootdemo.dao.UserDao;
import com.mongodb.springbootdemo.entity.User;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : chenpeng
 * @date : 2018-08-05 19:03
 */
@Controller
@RequestMapping(value = "/index")
public class UserController {
  @Autowired
  private UserDao userRepository;

  @Autowired
  private MongoTemplate mongoTemplate;

  //首页
  @RequestMapping(value = "/index")
  public String index(Model model, HttpServletRequest request) {

    User user = (User) request.getAttribute("user");

    if (user == null) {
      //  System.out.println(user);
      User usero = new User("##errors##", "1234");
      model.addAttribute("user", usero);
    }

    return "index";
  }

  //登录界面
  @RequestMapping(value = "/oplogin")
  public String oplogin() {
    return "login";
  }

  /**
   * 登录
   * @param request is not null
   * @return
  */
  @RequestMapping(value = "/login")
 public String login(HttpServletRequest request) {
    //获取用户和密码
    String username = request.getParameter("username");
    String password = request.getParameter("password");


    //根据用户名查询，用户是否存在
    User user = userRepository.findByUsername(username);
    //如果存在
    if (user != null) {
      if (password.equals(user.getPassword())) {
        //如果密码正确
        //将用户信息放入到会话中...
        request.setAttribute("user", user);
        return "index";
      } else {
        //如果密码错误
        System.out.println("密码错误");
        return "ferror";
      }
    } else {
      //如果不存在，代码邮箱和密码输入有误
      System.out.println("用户不存在");
      return "ferror";
    }

  }
 /**
 * 打开注册界面
 * @return
 */
  @RequestMapping("/resgi")
  public String resgi() {
    return "resgi";
  }


}
