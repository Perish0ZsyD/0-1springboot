package com.tutorial.boot_demo.controller;

import com.tutorial.boot_demo.Response;
import com.tutorial.boot_demo.dao.Student;
import com.tutorial.boot_demo.dto.StudentDTO;
import com.tutorial.boot_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Siyuan
 * @date 2024/11/01/19:54
 */
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}") // 缺点，不想把一些字段暴露给前端，借助DTO来解决
    public Response<StudentDTO> getStudentById(@PathVariable long id) {
        return Response.newSuccess(studentService.getStudentById(id));
    }
    // 后端结果统一封装，接口请求是否正常

    @PostMapping("/student")
    public Response<Long> addNewStudent(@RequestBody StudentDTO studentDTO) {

        return Response.newSuccess(studentService.addNewStudent(studentDTO));
    }

    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("student/{id}")
    public Response<StudentDTO> updatestudentById(@PathVariable long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        return Response.newSuccess(studentService.updateStudentById(id, name, email));
    }
}
