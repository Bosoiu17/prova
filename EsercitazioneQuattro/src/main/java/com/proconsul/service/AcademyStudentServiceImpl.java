package com.proconsul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proconsul.entity.Academy;
import com.proconsul.entity.Student;
import com.proconsul.repository.AcademyRepository;
import com.proconsul.repository.StudentRepository;

@Service
public class AcademyStudentServiceImpl implements AcademyStudentService{

	@Autowired
	StudentRepository sr;
	
	@Autowired 
	AcademyRepository ar;
	
	
	@Override
	public String saveStudent(Student student,String academyCode) {
        if (student != null && academyCode!= null) {
            try {
                if (sr.findById(student.getId()).isEmpty()) {
                	student.setAcademy(ar.findById(academyCode).get());
                    sr.save(student);
                    return "academiesList";
                }
                return "error";
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return "error";
            }
        } else {
            return "error";
        }
    }

	@Override
    public String saveAcademy(Academy academy) {
        if (academy != null) {
            try {
                if (ar.findById(academy.getCode()).isEmpty()) {
                    ar.save(academy);
                    return "academiesList";
                }
                return "error";
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return "error";
            }
        } else {
            return "error";
        }
    }
    
	@Override
	public String updateStudent(Student student) {
        if (student != null) {
            try {
                if (sr.findById(student.getId()).isPresent()) {
                    sr.save(student);
                    return "academiesList";
                }
                return "error";
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return "error";
            }
        } else {
            return "error";
        }
    }

	@Override
    public String updateAcademy(Academy academy) {
        if (academy != null) {
            try {
                if (ar.findById(academy.getCode()).isPresent()) {
                	Academy academyToUpdate=ar.findById(academy.getCode()).get();
                	academyToUpdate.setTitle(academy.getTitle());
                	academyToUpdate.setLocation(academy.getLocation());
                	ar.save(academyToUpdate);
                    return "academiesList";
                }
                return "error";
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                return "error";
            }
        } else {
            return "error";
        }
    }
    
	@Override
    public String deleteStudent(int id) {
    	if (id !=0) {
            sr.deleteById(id);
            if(!sr.existsById(id)) {
            	return "academiesList";
            }
            else {
            	return "error";
            }
        }
            return "error";
    
    }
    
	@Override
    public String deleteAcademy(String code) {
        if (code != null) {
            ar.deleteById(code);
            if(!ar.existsById(code)) {
            	return "academiesList";
            }
            else {
            	return "error";
            }
        }
            return "error";
    
    }

	@Override
	public List<Student> findAllStudentsByAcademy(String AcademyCode) {
		Academy a = ar.findById(AcademyCode).get();
		return a.getStudents();

	}
	@Override
	public List<Academy> findAllAcademies() {
            return ar.findAll();
 
	}

	@Override
	public String checkFindAllStudents(String AcademyCode) {
		if(AcademyCode!=null) {
			//if( !findAllStudentsByAcademy(AcademyCode).isEmpty()) {
				return "studentsList";
		//}
			//return "error";
		}
		return "error";
	}

	@Override
	public String checkFindAllAcademies() {
		if(!findAllAcademies().isEmpty()) {
			return "academiesList";
		}
		return "error";
	}

	@Override
	public Academy findAcademyByCode(String code) {
		return ar.findById(code).get();
	}
	
	@Override
	public Student findStudentById(int id) {
		return sr.findById(id).get();
	}
	
   @Override
	public Student findStudentToAdd(String AcademyCode) {
		Student student =new Student();
		student.setAcademy(ar.findById(AcademyCode).get());
		return student;
	}
	
	
}