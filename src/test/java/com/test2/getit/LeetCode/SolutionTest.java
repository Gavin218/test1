package com.test2.getit.LeetCode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void canConstruct() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println('c'>'a');
    }

    @Test
    void colorBorder() {
        int[][] x = {{1,1},{1,2}};
        int[][] y = new Solution().colorBorder(x, 0, 0, 3);
        System.out.println(y);
    }
}