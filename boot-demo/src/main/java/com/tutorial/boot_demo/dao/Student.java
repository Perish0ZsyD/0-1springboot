package com.tutorial.boot_demo.dao;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 * @author Siyuan
 * @date 2024/11/01/19:46
 */
@Entity // 说明这是一个实体类和数据库表映射的类
@Table(name="student")
@Data // lombok依赖 自动生成getter和setter方法包括toString方法 也可以单独Getter Setter ToString注解
public class Student {

    @Id // 自增主键通过数据库自动生成
    @Column(name="id") // java对象属性名和数据库表名一致可以省略
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name="name") // Java类中数据映射到数据库中哪个字段
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="age")
    private int age;
}
