/*
Given an array of integers, every element appears twice except for one. Find that single one.

Input : [1 2 2 3 1]
Output : 3
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

package Challenges;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,2,3,1);
        System.out.println("Single Number is : " + singleNumber(input));
    }

    public static Integer singleNumber(List<Integer> input){
        Integer result = 0;
        for (Integer x :input) {
            result ^= x;
        }

        return result;
    }
}
