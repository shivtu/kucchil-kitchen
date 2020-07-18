package com.example.demoauth;

import com.example.retail.RetailApplication;
import com.example.retail.Welcome.Welcome;
import com.example.retail.Welcome.WelcomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RetailApplication.class)
class RetailApplicationTests {

	@Mock
	WelcomeController welcomeController;

	@InjectMocks
	Welcome welcome;

	@Value("${welcome.message}")
	private String welcomeMessage;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void displayWelcomeMessage() {
		String welcomeMessageRes = welcomeMessage;
		when(welcomeController.returnWelcomeMessage()).thenReturn("Welcome to " + welcomeMessageRes);

		String welcomeText = welcomeController.returnWelcomeMessage();

		assertNotNull(welcome);
		assertEquals("Welcome to "+welcomeMessage, welcomeText);
	}
}
