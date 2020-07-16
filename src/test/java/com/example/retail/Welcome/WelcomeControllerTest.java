package com.example.retail.Welcome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WelcomeControllerTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    final void returnWelcomeMessage() {
        Welcome welcome = new Welcome();
        WelcomeController welcomeController = new WelcomeController();

        String expect = "Welcome to RetailApp";
        String actual = welcomeController.returnWelcomeMessage();

        assertEquals(expect, actual);
    }
}