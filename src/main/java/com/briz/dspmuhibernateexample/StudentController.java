package com.briz.dspmuhibernateexample;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepository erepo;
	
	@RequestMapping("/test") //demo
	public String test()
	{
		return "This is dspmu test";
	}
@RequestMapping("/save") //student data input from postman
public String save(@RequestBody Student student)
{
	erepo.save(student);
	return "Data save into database";
	}


@RequestMapping("/all") //Display of student details.
public List<Student> alldata()
{
	return erepo.findAll();
}


@RequestMapping("/{id}") //searching student details using student id.
public Optional<Student> byid(@PathVariable int id)
{
	return erepo.findById(id);
	}

@RequestMapping("/del/{id}") //deleting of studnet details using student id.
public String del(@PathVariable int id)
{
	Student s=erepo.findById(id).get();
	erepo.deleteById(id);
	return "Id deleted";
}


@RequestMapping("/name/{name}") //searching of student details using student by name
public List<Student> byName(@PathVariable String name)
{
	return erepo.findByName(name);
	}


@RequestMapping("/both/{name}/{city}") //searching using name and city.
public List<Student> byNameAndCity(@PathVariable String name,@PathVariable String city)
{
	return erepo.findByNameAndCity(name,city);
	}


@RequestMapping("/boths/{name}/{city}") //searching using name or city.
public List<Student> byNameOrCity(@PathVariable String name,@PathVariable String city)
{
	return erepo.findByNameOrCity(name,city);
	}


@RequestMapping("/update/{id}") //updating student info.
public Student Update(@RequestBody Student student,@PathVariable int id)
{
	Student s=erepo.findById(id).get();
	s.setName(student.getName());
	s.setAge(student.getAge());
	s.setCity(student.getCity());
	return erepo.save(s);
	}
}