package com.offcn.controller;

import com.offcn.pojo.Member;
import com.offcn.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/getMemberList.action")
    public ModelAndView getMemberList(){
        List<Member> memberList = memberService.getMemberList();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",memberList);
        modelAndView.setViewName("member-data");
        return modelAndView;
    }
}
