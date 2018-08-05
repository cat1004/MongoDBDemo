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

}
