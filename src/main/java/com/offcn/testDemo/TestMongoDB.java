package com.offcn.testDemo;

import com.offcn.pojo.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-mongoDB.xml"})
public class TestMongoDB {
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void test01(){
        Set<String> colls = mongoTemplate.getCollectionNames();
        for (String name:colls
             ) {
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        Member member=new Member();
        member.setM_name("tim");
        mongoTemplate.insert(member);
    }

    @Test
    public void test03(){
        Query query =new Query();
        query.addCriteria(Criteria.where("m_name").is("tim"));
        List<Member> members = mongoTemplate.find(query, Member.class);
        for (Member member:members
             ) {
            System.out.println(member);
        }
    }

    @Test
    public void test04(){
        List<Member> all = mongoTemplate.findAll(Member.class);
        for (Member member:all
             ) {
            System.out.println(member
            );
        }
    }
    @Test
    public void test05(){
        Query query =new Query();
        query.addCriteria(Criteria.where("m_name").is("tom"));
        Member member  = mongoTemplate.findOne(query, Member.class);
        member.setM_name("cat");
        //update
        mongoTemplate.save(member);
    }
}