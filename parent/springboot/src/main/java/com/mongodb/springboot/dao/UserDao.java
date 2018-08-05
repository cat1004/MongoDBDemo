package com.mongodb.springboot.dao;

import com.mongodb.springboot.entity.UserEntity;

/**
 * @author : chenpeng
 * @date : 2018-08-05 15:12
 */
public interface UserDao  {
  void saveUser(UserEntity user);
  UserEntity findUserByUserName(String userName);
  Long updateUser(UserEntity user);
  void deleteUserById(Long id);

}
