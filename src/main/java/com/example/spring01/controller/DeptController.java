package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.model.dto.DeptVO;
import com.example.spring01.service.DeptService;

@Controller
public class DeptController {
	
	@Inject
	DeptService deptSerivce;
	
	@RequestMapping(value = "dept/list.do")
	public String deptList(Model model) {
		List<DeptVO> list=deptSerivce.deptList();
		model.addAttribute("list", list);
		return "dept/dept_list";
	}

}
