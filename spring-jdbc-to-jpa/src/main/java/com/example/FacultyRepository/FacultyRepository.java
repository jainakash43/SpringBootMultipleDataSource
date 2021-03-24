package com.example.FacultyRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.FacultyEntity.Faculty;


public interface FacultyRepository extends CrudRepository<Faculty ,Integer>{

}
