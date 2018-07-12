package com.offcn.service;

import com.offcn.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Member> getMemberList() {
        List<Member> all = mongoTemplate.findAll(Member.class);
        return all;
    }

    @Override
    public void memberUpdate(Member member) {
        mongoTemplate.save(member);
    }
}
