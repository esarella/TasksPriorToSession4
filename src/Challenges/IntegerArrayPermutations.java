/*
Write a program that takes as its input an int[] containing 2 or more values and returning all possible permutations
of the numbers.

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]

Note: No two entries in the permutation sequence should be the same. For the purpose of this problem,
assume that all the numbers in the collection are unique. Do not use any library functions for generating permutations.
 */
package Challenges;

import java.util.ArrayList;

public class IntegerArrayPermutations {
    private static ArrayList<Integer> input;
    private boolean[] marked;
    private ArrayList<ArrayList<Integer>> result;
    private int n;

    public static void main(String[] args) {
        input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        IntegerArrayPermutations test = new IntegerArrayPermutations();
        test.integerArrayPermutations(input);
    }

    private void integerArrayPermutations(ArrayList<Integer> input) {
        n = input.size();
        marked = new boolean[n];
        result = new ArrayList<>();

        recurse(0, new ArrayList<>());

        System.out.println(result);

    }

    private void recurse(int index, ArrayList<Integer> temp) {
        if (index == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                marked[i] = true;
                temp.add(input.get(i));
                recurse(index + 1, temp);
                marked[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
