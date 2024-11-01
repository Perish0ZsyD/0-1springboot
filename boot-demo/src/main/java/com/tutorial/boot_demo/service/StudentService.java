package com.tutorial.boot_demo.service;

//import com.tutorial.boot_demo.dao.Student;
import com.tutorial.boot_demo.dto.StudentDTO;

/**
 * @author Siyuan
 * @date 2024/11/01/19:50
 */
public interface StudentService {
    // 修改返回值，原来为Student，现在为StudentDTO，前端，我们让他们看到的是DTO，而不是实体类
    StudentDTO getStudentById(long id);


    Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentById(long id);

    StudentDTO updateStudentById(long id, String name, String email);
}
