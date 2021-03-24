package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.StudentEntity.Student;



public class StudentDaoImpl implements StudentDao {
    
	

	
	
	public  int insert(Student student,JdbcTemplate jdbcTemplate) {
		
		String query = "insert into student(student_Id,student_Name,City) values(?,?,?)";
		int r = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
    
	public int update(Student student, JdbcTemplate jdbcTemplate)
	{
		String query = "update student set student_Id=? where City=?";
		int r = jdbcTemplate.update(query,student.getId(),student.getCity());
		return r;
	}
	
	public int delete(int id, JdbcTemplate jdbcTemplate)
	{
		String query = "delete from student where student_Id=?";
		int r = jdbcTemplate.update(query,id);
		return r;
	}
	
	public Student select(int id, JdbcTemplate jdbcTemplate)
	{
		String query = "select * from student where student_Id=?";
		
		RowMapper<Student> rowMapper = (rs,rownum)->{
			Student student = new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setCity(rs.getString(3));
			return student;
		};
		
		Student stud = jdbcTemplate.queryForObject(query, rowMapper, id);
		
		
		return stud;
	}
	
	public List<Student> getAllStudent(JdbcTemplate jdbcTemplate)
	{
		String sql = "select * from student";

		RowMapper<Student> rowMapper = (rs,rownum)->{
			Student student = new Student();
			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setCity(rs.getString(3));
			return student;
		};
		List<Student> li = jdbcTemplate.query(sql,rowMapper);
		return li;
	}
	
	
}
