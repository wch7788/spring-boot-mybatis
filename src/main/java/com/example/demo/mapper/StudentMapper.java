package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.Address;
import com.example.demo.bean.Student;

@Mapper
public interface StudentMapper {
	public void add(Student student);
	public void delete(int id);
	public void update(Student student);
	public Student FindStudent(int id);
	public List<Student> FindStudentByCid(int id);
	
	public List<Student> FindStudentByAgeOrName(Student student);

}
