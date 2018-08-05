package com.mongodb.springbootdemo.dao;

import com.mongodb.springbootdemo.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author : chenpeng
 * @date : 2018-08-05 19:04
 */
public interface UserDao extends MongoRepository<User, String> {
  /**
  *
  * findByUsername 命名有研究，比如 findBy后面的名称是实体类属性名称
  * Username*
  */
  User findByUsername(String username);
}