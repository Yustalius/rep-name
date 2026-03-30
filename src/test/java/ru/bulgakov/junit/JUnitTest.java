package ru.bulgakov.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class JUnitTest {

    @Nested
    public class PositiveTest {
        @RepeatedTest(3)
        @EnabledIfEnvironmentVariable(named = "env", matches = "dev")
        void test1() {
            System.out.println("Test 1");
        }

        @Test
        @Tag("positive")
        @DisplayName("ТОрой тест")
        @Disabled("oi")
        void test2() {
            System.out.println("Test 2");
        }

        @Test
        @DisabledOnOs
        void test3() {
            System.out.println("Test 3");
        }
    }

    @Nested
    public class NegativeTest {
        @Test
        void test1() {
            System.out.println("Test 1");
        }

        @Test
        void test2() {
            System.out.println("Test 2");
        }
    }

    enum Color {RED, BLUE, GREEN}

    @ParameterizedTest
    @MethodSource("wordLetterCountProcider")
     void MiddleTest(String name, int count) {
        System.out.println(name + count);
    }



    static Stream<Arguments> wordLetterCountProcider(){
        return Stream.of(
                Arguments.of("Vlad", 4 ),
                Arguments.of("ca", 213),
                Arguments.of("adab daba", 322)
        );
    }

}





