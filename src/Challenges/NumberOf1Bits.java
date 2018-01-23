/*
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

For example, the 32-bit integer 11 has binary representation:

00000000000000000000000000001011
so the function should return 3.

Note: that since Java does not have unsigned int, use long for Java.
 */
package Challenges;

public class NumberOf1Bits {
    public static void main(String[] args) {
        long input = 00000000000000000000000000001011;
        System.out.println("number of 1 bits in " + input + " = " + numberOf1Bits(input));

    }

    public static int numberOf1Bits (long input){
        int result = 0;

        while(input > 0){
            if((input & 1) != 0){
                result++;
            }
            input >>= 1;
        }
        return result;
    }
}
