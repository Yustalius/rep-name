package ru.bulgakov.junit;

import org.junit.jupiter.api.*;

public class JUnitTest {

    @BeforeAll
    static void setUp() {
        System.out.println("Перед всеми");
    }

    @BeforeEach
    void before() {
        System.out.println("Перед каждым тестом");
    }

    @AfterEach
    void after() {
        System.out.println("После каждого теста");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("После всех тестов");
    }


    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 1");
    }
}
