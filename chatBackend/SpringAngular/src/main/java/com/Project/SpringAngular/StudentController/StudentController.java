package com.Project.SpringAngular.StudentController;

import com.Project.SpringAngular.DTO.StudentDTO;
import com.Project.SpringAngular.DTO.StudentSaveDTO;
import com.Project.SpringAngular.DTO.StudentUpdatedDTO;
import com.Project.SpringAngular.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/save")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO) {
        String id = studentService.addStudent(studentSaveDTO);
        return " user sucessfully added";

    }

    @GetMapping(path = "/getAllStud")
    public List<StudentDTO> getAllStud()
    {
        List<StudentDTO>allStud = studentService.getAllStud();
        return allStud;
    }

    @PutMapping(path = "/update")
    public  String updateStud(@RequestBody StudentUpdatedDTO studentUpdatedDTO)
    {
        String id = studentService.updateStudent(studentUpdatedDTO);
        return id;
    }

    @DeleteMapping(path = "/deleteStud/{id}")
    public String deletestud(@PathVariable(value = "id") int id)
    {
        boolean deleteStud = studentService.deleteStud(id);
        return "deleted";
    }

}
