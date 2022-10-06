package com.proconsul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.proconsul.entity.Academy;
import com.proconsul.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	public List<Student> findByAcademy(Academy academy);
	

//	@Modifying
//	@Query("delete from User u where u.firstName = ?1")
//	void deleteStudentById(String firstName);


}
