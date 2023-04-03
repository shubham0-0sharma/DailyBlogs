package com.noobdev.dailyblog.dailyblog;

import com.noobdev.dailyblog.dailyblog.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DailyblogApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public  void repoTest() {
		String className =  userRepository.getClass().getName();
		String packageName = this.userRepository.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packageName);
	}
}
