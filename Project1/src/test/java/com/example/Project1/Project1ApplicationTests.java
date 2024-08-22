package com.example.Project1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = Project1Application.class)
@ActiveProfiles("test")
class Project1ApplicationTests {

	@Test
	void contextLoads() {
	}

}
