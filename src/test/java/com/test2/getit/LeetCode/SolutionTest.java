package com.test2.getit.LeetCode;

import com.fasterxml.jackson.datatype.jdk8.OptionalIntDeserializer;
import com.test2.getit.GetitApplication;
import com.test2.getit.leetcode.Solution;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;
@TestConfiguration

@SpringBootTest(classes = GetitApplication.class)

class SolutionTest {

    @Autowired
    private Solution solution;

    @Test
    void canConstruct() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println('c'>'a');
    }

    @Test
    void colorBorder() {
        int[][] x = {{1,1},{1,2}};
        int[][] y = solution.colorBorder(x, 0, 0, 3);
        System.out.println(y);
    }

    @Test
    void toLowerCase() {
        System.out.println(solution.toLowerCase("Hello"));
    }

    @Test
    void maxIncreaseKeepingSkyline() {
        int[][] x = {{3, 0, 8, 4},{2, 4, 5, 7},{9, 2, 6, 3},{0, 3, 1, 0}};
        int y = solution.maxIncreaseKeepingSkyline(x);
        System.out.println(y);
        System.out.println(Arrays.stream(x[0]).min());
        int s = 5;
        String ss = Integer.toString(s);
        System.out.println(ss);


    }

    @Test
    void fizzBuzz() {
        List<String> list = solution.fizzBuzz(15);
        System.out.println(list);
    }
}