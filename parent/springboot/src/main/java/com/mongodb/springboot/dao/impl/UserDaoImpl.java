package com.mongodb.springboot.dao.impl;

import com.mongodb.client.result.UpdateResult;
import com.mongodb.springboot.dao.UserDao;
import com.mongodb.springboot.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * @author : chenpeng
 * @date : 2018-08-05 15:14
 */
@Component
public class UserDaoImpl implements UserDao {

  @Autowired
  private MongoTemplate mongoTemplate;

  /**
  * 创建对象
  * @param user is not null
  */
  @Override
  public void saveUser(UserEntity user) {
    mongoTemplate.save(user);
  }

  /**
  * 根据用户名查询对象
  * @param userName is not null
  * @return
  */
  @Override
 public UserEntity findUserByUserName(String userName) {
    Query query = new Query(Criteria.where("userName").is(userName));
    UserEntity user =  mongoTemplate.findOne(query, UserEntity.class);
    return user;
  }
  /**
   * 更新对象
   * @param user is not null
   * @return
   */

  @Override
  public Long updateUser(UserEntity user) {
    Query query = new Query(Criteria.where("id").is(user.getId()));
    Update update = new Update().set("userName", user.getUserName())
            .set("passWord", user.getPassWord());
    //更新查询返回结果集的第一条
    UpdateResult result = mongoTemplate.upsert(query, update, UserEntity.class);
    //更新查询返回结果集的所有
    // mongoTemplate.updateMulti(query,update,UserEntity.class);
    if (result != null) {
      return result.getMatchedCount();
    } else {
      return 0L;
    }
  }

  @Override
  public void deleteUserById(Long id) {
    Query query = new Query(Criteria.where("id").is(id));
    mongoTemplate.remove(query, UserEntity.class);
  }
}