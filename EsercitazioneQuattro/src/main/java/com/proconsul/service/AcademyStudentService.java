package com.proconsul.service;

import java.util.List;

import com.proconsul.entity.Academy;
import com.proconsul.entity.Student;

public interface AcademyStudentService {

	public String saveStudent(Student student,String academyCode);
	public String saveAcademy(Academy academy);
	public String updateStudent(Student student);
	public String updateAcademy(Academy academy);
	public String deleteStudent(int id);
	public String deleteAcademy(String code);
	public List<Student> findAllStudentsByAcademy(String AcademyCode);
	public List<Academy> findAllAcademies();
	public String checkFindAllStudents(String AcademyCode);
	public String checkFindAllAcademies();
	public Academy findAcademyByCode(String code);
	public Student findStudentToAdd(String AcademyCode);
	public Student findStudentById(int id);
}
