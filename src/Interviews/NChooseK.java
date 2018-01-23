/*
Calculating n choose k
The binomial coefficient, is often read aloud as "n choose k" and is used to denote the number of different
ways to choose k elements from a set of n elements without respect to their order.

There are a number of different approaches to calculating this value, including a well-known approach using
recursion:

Stated another way, the value for (n choose k) is equal to the sum of (n - 1 choose k - 1) and (n - 1 choose k).

Write a program that takes as its input two int values n and k and implements the above algorithm using tail
recursion, returning a long value representing the number of different ways to choose k elements from a set of
n elements.

Hint: there two base cases to consider

*/

// 1 <= k <= n - 1

package Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NChooseK {
    public static void main(String[] args) {
//        int n = 50;
//        int k = 20;
//        int n = 20;
//        int k = 5;
//        int n = 30;
//        int k = 5;
//        double runTimeWithoutMemoization = runNChooseK(n,k, false);
//        double runTimeWithMemoization = runNChooseK(n, k, true);
//        System.out.println("Time Difference  =  " + (runTimeWithoutMemoization - runTimeWithMemoization));

        List<List<Integer>> result = new ArrayList<>() ;
        List<Integer> one = Arrays.asList(1);
        List<Integer> two = Arrays.asList(1,2);
        List<Integer> three = Arrays.asList(1,2,3);
        result.add(one);
        result.add(two);
        result.add(three);

        printPascalsTriangle(result);

    }

    public static double runNChooseK(int n, int k, boolean memoization) {
        long startTime = System.nanoTime();

        long result;

        if (memoization) {
            HashMap<String, Long> map = new HashMap<>();
            result = computeNChooseKWithMemoization(n, k, map);
            System.out.println("Result for n = " + n + " and k = " + k + " with Memoization = " + result);
        } else {
            result = computeNChooseK(n, k);
            System.out.println("Result for n = " + n + " and k = " + k + " without Memoization = " + result);
        }

        long endTime = System.nanoTime();
        return ((endTime - startTime)  / 1e6 );
    }

    public static long computeNChooseK(int n, int k) {
        if (k >= n) {
            return (long) 1;
        } else if (k == 1) {
            return (long) n;
        }
        return computeNChooseK(n - 1, k - 1) + computeNChooseK(n - 1, k);
    }

    public static long computeNChooseKWithMemoization(int n, int k, HashMap<String, Long> map) {

        if (k >= n) {
            return (long) 1;
        } else if (k == 1) {
            return (long) n;
        }

        String key = "N:" + n + ";" + "K:" + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        long sum = computeNChooseKWithMemoization(n - 1, k - 1, map) + computeNChooseKWithMemoization(n - 1, k, map);
        map.put(key, sum);

        return sum;
    }

    static void printPascalsTriangle(List<List<Integer>> result) {
        for (List x: result) {
            for (Object y: x) {
                System.out.print(y+ " ");

            }
            System.out.println();
        }

    }
}
