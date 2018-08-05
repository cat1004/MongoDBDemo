package com.mongodb.driver.test.com.mongodb.crud;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
/**
 * @author : chenpeng
 * @date : 2018-08-05 11:22
 */
public class MongoDBTest4 {
  public static void main(String[] args) {
    try {
      // 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient("localhost", 27017);

      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
      System.out.println("Connect to database successfully");

      MongoCollection<Document> collection = mongoDatabase.getCollection("test");
      System.out.println("集合 test 选择成功");
      //检索所有文档
      /**
       * 1. 获取迭代器FindIterable<Document>
       * 2. 获取游标MongoCursor<Document>
       * 3. 通过游标遍历检索出的文档集合
       * */
      FindIterable<Document> findIterable = collection.find();
      MongoCursor<Document> mongoCursor = findIterable.iterator();
      while (mongoCursor.hasNext()) {
        System.out.println(mongoCursor.next());
      }
    } catch (Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
    }
  }
}
