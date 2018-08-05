package com.mongodb.springboot.dao.impl;

import com.mongodb.springboot.dao.UserDao;
import com.mongodb.springboot.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author : chenpeng
 * @date : 2018-08-05 15:14
 */
@Component
public class UserDaoImpl implements UserDao {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public void saveUser(UserEntity user) {

  }

  @Override
 public UserEntity findUserByUserName(String userName) {
    return null;
  }

  @Override
  public int updateUser(UserEntity user) {
    return 0;
  }

  @Override
  public void deleteUserById(Long id) {

  }
}