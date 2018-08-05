package com.mongodb.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author : chenpeng
 * @date : 2018-08-05 11:01
 */
public class MongDBJDBC {
  public static void main(String[] args) {
    try {
      // 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient("localhost", 27017);

      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
      System.out.println("Connect to database successfully");

    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }
}
