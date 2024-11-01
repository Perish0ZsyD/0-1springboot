package com.tutorial.boot_demo.service;

import ch.qos.logback.core.util.StringUtil;
import com.tutorial.boot_demo.converter.StudentConverter;
import com.tutorial.boot_demo.dao.Student;
import com.tutorial.boot_demo.dao.StudentRepository;
import com.tutorial.boot_demo.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Siyuan
 * @date 2024/11/01/19:50
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public StudentDTO getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        // 邮箱是唯一的，如果存在，就不添加
        List<Student> studentList = studentRepository.findByEmail(studentDTO.getEmail());
        if (!CollectionUtils.isEmpty(studentList)) {
            throw new IllegalStateException("email: " + studentDTO.getEmail() + " is already taken");
        }

        Student student =  studentRepository.save(StudentConverter.convertStudent(studentDTO));
        return student.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id: " + id + " does not exist!")); // 如果不存在，抛出异常
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional // 提交失败回滚
    public StudentDTO updateStudentById(long id, String name, String email) {
        Student studentInDB = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id: " + id + " does not exist!"));
        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)) { // 如果名字不为空，且名字不相等，则修改数据库中的名字
            studentInDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)) {
            studentInDB.setEmail(email);
        }
        Student student = studentRepository.save(studentInDB);
        return StudentConverter.convertStudent(student);
    }

}
