package com.mongodb.springbootdemo.entity;

import org.springframework.data.annotation.Id;

/**
 * @author : chenpeng
 * @date : 2018-08-05 19:04
 */

public class User {

  /**
   * cid：该字段用于mongodb的“_id"索引 1 需要
   * @Id的注解 2定义为String类型  ，
   * 如果定义为Integer可能索引只会是0 会出现key重复导致数据库插不进去的情况
   * 3该类型也是MongoRepository泛型类主键的ID
  */
  @Id
  private String cid;
  private String username;
  private String password;

  public User() {

  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


}