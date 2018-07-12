package com.offcn.service;

import com.offcn.pojo.Member;

import java.util.List;

public interface MemberService {
    public List<Member> getMemberList();
    public void memberUpdate(Member member);
}
