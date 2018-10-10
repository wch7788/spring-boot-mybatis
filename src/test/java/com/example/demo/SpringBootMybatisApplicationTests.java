package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.Address;
import com.example.demo.bean.Class;
import com.example.demo.bean.Student;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {
  @Autowired
   AddressMapper addressmapper;
  @Autowired
  ClassMapper classmapper;
  @Autowired
  StudentMapper studentmapper;
  
     

	
	
	@Test
	public void Test() {
		//this.addAddress();
		//this.deleteAddress();
		/*this.updateAddress();*/
		/*this.FindAddress();*/
		//this.addClass();
		//this.deleteClass();
      	//this.updateClass();
     	//this.FindClass();
		//this.addStudent();
		//this.deleteStudent();
		//this.updateStudent();
		this.getStudent();
		//this.getStudentsByclass();
	}
	
   public void addAddress(){
	   Address address=new Address();
	   address.setId(17);
	   address.setAddress("xxxx");
	   addressmapper.add(address);
   }	
   
   public void addClass(){
	   Class classroom=new Class();
	   classroom.setId(1234);
	   classroom.setName("1234班");
	   classmapper.add(classroom);
   }
   
   public void addStudent(){
	   Student student=new Student();
	   student.setId(153);
	   student.setAge(66);
	   student.setName("王二");
	   Address address=new Address();
	   address.setId(215332);
	   student.setAddress(address);
	   studentmapper.add(student);
	   
	   
   }
   
   public void deleteAddress(){
	   addressmapper.delete(1);
	   
   }
   public void deleteClass(){
	   classmapper.delete(1234);
   }
   public void deleteStudent(){
	   studentmapper.delete(153);
   }
   
   public void updateAddress(){
	   Address address=new Address();
	   address.setId(97);
	   address.setAddress("97号");
	  addressmapper.update(address); 
	 }
   
   public void updateClass(){
	   Class classroom=new Class();
	   classroom.setId(103);
	   classroom.setName("103班");
	   classmapper.update(classroom);
   }
   
   public void updateStudent(){
	   
	   Student student=new Student();
	   student.setId(123);
	   student.setAge(66);
	   student.setName("刘三");
	   studentmapper.update(student);
	   
   }
   
   public void FindAddress(){
	   addressmapper.Findbyid(1);
	   
   }
   
   public void FindClass(){
	   classmapper.Findbyid(103);
	   
   }
   //一对一
   public void getStudent(){
	   studentmapper.FindStudent(2);
   }
  
   
 public void getStudentsByclass(){
	   classmapper.getStudents(102);
   }
 
   
}
