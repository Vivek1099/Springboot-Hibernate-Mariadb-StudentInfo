package com.briz.dspmuhibernateexample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
List<Student> findByName(String name);
List<Student> findByCity(String city);
List<Student> findByNameAndCity(String name,String city);
List<Student> findByNameOrCity(String name,String city);
}
