package com.offcn.testDemo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.nio.charset.Charset;

public class TestJedis {

    @Test   //解决编码问题
    public void test01(){
       /* Jedis jedis = new Jedis("192.168.8.131",6379);
        jedis.set("company","百度");
        String company = jedis.get("company");
        System.out.println(company);*/
        Jedis jedis = new Jedis("192.168.8.131",6379);
//            jedis.auth("登录密码");
//        向redis中存入字符串company
        jedis.set("company","阿里巴巴");
        System.out.println(jedis.get("company"));
        jedis.close();
    }
    @Test
    public void  testJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMinIdle(5);

        String host="192.168.8.131";
        int port=6379;
        JedisPool jedisPool = new JedisPool(config, host, port);
        Jedis jedis = jedisPool.getResource();
        jedis.set("username","小米");
        String username= jedis.get("username");
        System.out.println();
    }
    @Test
    public void  testJedis(){
        ApplicationContext app=new ClassPathXmlApplicationContext("classpath:applicationContext-redis.xml");
        JedisPool jedisPool = (JedisPool) app.getBean("jedisPool");
        Jedis jedis = jedisPool.getResource();
        jedis.set("a","a");
        System.out.println(jedis.get("a"));
        jedis.close();
    }
}
