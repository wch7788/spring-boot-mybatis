package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.Address;
import com.example.demo.bean.Class;
import com.example.demo.bean.Student;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;

@Controller
public class StudentController {
   int studentid;
	@Autowired
	StudentMapper studentmapper;
	@Autowired
	AddressMapper addressmapper;
	@Autowired
	ClassMapper classmapper;
	
	
	//展示所有学生
	@RequestMapping(value="getStudent")
	public ModelAndView getStudent(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		List<Student> list=studentmapper.FindAllStudent();
		
		
		mv.addObject("students",list );
		mv.setViewName("student");
		return mv;
		
     }
	
	//删除功能
	@RequestMapping(value="delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.valueOf(request.getParameter("id"));
		addressmapper.delete(studentmapper.FindStudent(id).getAddress().getId());
		studentmapper.delete(id);
		return new ModelAndView("redirect:/getStudent");
		
	}
	
	//修改跳转页面
	
	@RequestMapping(value="update")
	public String update(HttpServletRequest request,HttpServletResponse response){
		studentid=Integer.valueOf(request.getParameter("id"));
		return "update";
		
	}
	
	//确定修改
	@RequestMapping(value="updateConfirm")
	public ModelAndView updateConfirm(HttpServletRequest request,HttpServletResponse response){
		System.out.println(request.getParameter("name"));
		Student student =new Student();
		student.setId(studentid);
		student.setName(request.getParameter("name"));
		student.setAge(Integer.valueOf(request.getParameter("age")));
		studentmapper.update(student);
		return new ModelAndView("redirect:/getStudent");
	}
	
	
	
	
	
	@RequestMapping(value="addAddress")
	public void addAddress(Address address){
		addressmapper.add(address);
		
	}
	

	
	@RequestMapping(value="getClass")
	public void getClass(Class classroom){
		
		System.out.println(classroom.getId());
	}
	
}
