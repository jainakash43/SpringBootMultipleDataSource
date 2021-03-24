package com.example.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.StudentEntity.Student;

public interface StudentDao {

	public int insert(Student student,JdbcTemplate jdbcTemplate);
	public int update(Student student, JdbcTemplate jdbcTemplate);
	public int delete(int id, JdbcTemplate jdbcTemplate);
	public Student select(int id, JdbcTemplate jdbcTemplate);
	public List<Student> getAllStudent(JdbcTemplate jdbcTemplate);
	
}
