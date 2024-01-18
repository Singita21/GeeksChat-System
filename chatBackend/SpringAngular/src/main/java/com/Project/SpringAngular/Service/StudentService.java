package com.Project.SpringAngular.Service;

import com.Project.SpringAngular.DTO.StudentDTO;
import com.Project.SpringAngular.DTO.StudentSaveDTO;
import com.Project.SpringAngular.DTO.StudentUpdatedDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStud();

    String updateStudent(StudentUpdatedDTO studentUpdatedDTO);

    boolean deleteStud(int id);


}
