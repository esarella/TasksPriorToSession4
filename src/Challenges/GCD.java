/*
The greatest common divisor (gcd) of two or more non-zero integers is the largest positive integer that divides all the numbers without a remainder.

Write a program that takes as its input two int values > 0 and returns an int value equal to their gcd.
 */

package Challenges;

public class GCD {
    public static void main(String[] args) {
        System.out.println("GCD of 20 and 30 = " + gcd(20,30));
    }

    public static int gcd(int x, int y){
        if(x == 0)
            return y;
        else
            return gcd(y%x, x);
    }
}
