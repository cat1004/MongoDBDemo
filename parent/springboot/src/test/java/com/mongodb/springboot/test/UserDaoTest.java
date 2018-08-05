package com.mongodb.springboot.test;

import com.mongodb.springboot.dao.UserDao;
import com.mongodb.springboot.entity.UserEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : chenpeng
 * @date : 2018-08-05 15:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
  @Autowired
  private UserDao userDao;

  @Test
  public void testSaveUser() throws Exception {
    UserEntity user = new UserEntity();
    user.setId(2L);
    user.setUserName("笑话");
    user.setPassWord("fffooo123");
    userDao.saveUser(user);
  }

  @Test
  public void findUserByUserName() {
    UserEntity user = userDao.findUserByUserName("笑话");
    System.out.println("user is " + user);
  }

  @Test
  public void updateUser() {
    UserEntity user = new UserEntity();
    user.setId(2l);
    user.setUserName("笑话");
    user.setPassWord("fffxxxx");
    Long aLong = userDao.updateUser(user);
    System.out.println(aLong);
  }

  @Test
  public void deleteUserById() {
    userDao.deleteUserById(1l);
  }

}
