/*

Compute factorial of an integer
The factorial of n is the product of all integers between 1 and n. For example, the factorial of 5 is computed as follows: 5*4*3*2*1 == 120.

Write a program that takes as its input a java.math.BigInteger and returns a java.math.BigInteger equal to the factorial of the input.

Hint: this can be implemented using a single static method with only one line of code.
 */

package Challenges;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int testVal = 15;
        factorial(testVal);
        System.out.println("factorial of "+ testVal +" = " + factorial1(testVal));
        System.out.println("factorial of "+ testVal +" = " + factorial2(BigInteger.valueOf(testVal)));

    }

    //iterative
    public static void factorial(int x) {
        int result = 1;
        for (int i = x; i >= 1; i--){
            result = result * i;
        }
        System.out.println("factorial of "+ x +" = " + result);
    }


    //recursive
    public static int factorial1(int x) {
        int result = 0;
        if (x == 0 || x == 1)
        {
            return 1;
        }
        else {
            result = x * factorial1(x - 1);
        }
        return result;
    }

    //BigInteger

    //    for(BigInteger a = BigInteger.ONE; a.compareTo(someBigInteger); a=a.add(BigInteger.ONE)) {.


    public static BigInteger factorial2 (BigInteger x){
        BigInteger result = BigInteger.ZERO;
        if (x.equals(BigInteger.ZERO) || x.equals(BigInteger.ONE)){
            return BigInteger.ONE;
        }
        else {
            result = x.multiply(factorial2(x.subtract(BigInteger.ONE)));
        }
        return result;
    }
}
