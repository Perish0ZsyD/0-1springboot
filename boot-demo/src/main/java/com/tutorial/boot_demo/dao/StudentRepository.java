package com.tutorial.boot_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Siyuan
 * @date 2024/11/01/19:57
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByEmail(String email);
}
