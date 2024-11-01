package com.tutorial.boot_demo.dao;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * @author Siyuan
 * @date 2024/11/01/19:46
 */
@Entity
@Table(name="student")
public class Student {

    @Id // 自增主键通过数据库自动生成
    @Column(name="id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name="name") // Java类中数据映射到数据库中哪个字段
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="age")
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
