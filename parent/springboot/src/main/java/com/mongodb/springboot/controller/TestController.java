package com.mongodb.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chenpeng
 * @date : 2018-08-05 14:55
 */
@RestController
public class TestController {
  @RequestMapping("")
  public String say() {
    return "spring boot start success";
  }
}
