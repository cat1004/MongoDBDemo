package com.mongodb.driver.test.com.mongodb.crud;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

/**
 * @author : chenpeng
 * @date : 2018-08-05 11:22
 */
public class MongoDBTest5 {
  public static void main(String[] args) {
    try {
      // 连接到 mongodb 服务
      MongoClient mongoClient = new MongoClient("localhost", 27017);

      // 连接到数据库
      MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
      System.out.println("Connect to database successfully");

      MongoCollection<Document> collection = mongoDatabase.getCollection("test");
      System.out.println("集合 test 选择成功");

      //更新文档   将文档中likes=100的文档修改为likes=200
      collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
      //检索查看结果
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
