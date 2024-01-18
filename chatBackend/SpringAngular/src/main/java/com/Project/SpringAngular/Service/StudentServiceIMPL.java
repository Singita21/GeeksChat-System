package com.Project.SpringAngular.Service;


import com.Project.SpringAngular.DTO.StudentDTO;
import com.Project.SpringAngular.DTO.StudentSaveDTO;
import com.Project.SpringAngular.DTO.StudentUpdatedDTO;
import com.Project.SpringAngular.Entity.Student;
import com.Project.SpringAngular.StudentRepo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

class StudentServiceIMPL implements  StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {
        Student student = new Student(
                studentSaveDTO.getStudentName(),
                studentSaveDTO.getStudentEmail(),
                studentSaveDTO.getMobile()
        );
        studentRepo.save(student);
        return student.getStudentName();

    }

    @Override
    public List<StudentDTO> getAllStud() {
        List<Student> getStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student a:getStudents){

            StudentDTO studentDTO = new StudentDTO(

                    a.getStudentId(),
                    a.getStudentName(),
                    a.getStudentEmail(),
                    a.getMobile()
            );
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;

    }

    @Override
    public String updateStudent(StudentUpdatedDTO studentUpdatedDTO) {
        if (studentRepo.existsById(studentUpdatedDTO.getStudentId())) {
            Student student = studentRepo.getById(studentUpdatedDTO.getStudentId());

            student.setStudentName(studentUpdatedDTO.getStudentName());
            student.setStudentEmail(studentUpdatedDTO.getStudentEmail());
            student.setMobile(studentUpdatedDTO.getMobile());

            studentRepo.save(student);
        }
        else{
                System.out.println("Customer ID do not EXist!");
            }
            return null;
        }

    @Override
    public boolean deleteStud(int id) {
        if (studentRepo.existsById(id))
        {
            studentRepo.deleteById(id);
        }
        else
        {
            System.out.println("Student id not FOUND!");

        }

        return true;
    }
}

