package com.tutorial.boot_demo;

import com.tutorial.boot_demo.dao.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootDemoApplicationTests {

	@Test
	void contextLoads() {
		Student student = new Student();
		student.getId(); // 借助lombok没有写get set方法的情况下直接调用
	}

}
