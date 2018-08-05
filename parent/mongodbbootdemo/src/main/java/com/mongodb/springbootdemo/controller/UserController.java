package com.mongodb.springbootdemo.controller;

import com.mongodb.springbootdemo.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
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
}
