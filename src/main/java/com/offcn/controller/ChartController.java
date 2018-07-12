package com.offcn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.pojo.ChartBean;

@Controller
public class ChartController {
	@RequestMapping("chart.action")
	@ResponseBody
	public List<ChartBean> getData(){
		List<ChartBean> list=new ArrayList<>();
		list.add(new ChartBean("250", "250"));
		list.add(new ChartBean("350", "220"));
		list.add(new ChartBean("400", "200"));
		list.add(new ChartBean("450", "300"));
		list.add(new ChartBean("470", "350"));
		return list;
	}
}