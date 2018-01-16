package BitManipulation;

import java.util.List;

public class SingleNumberII {
    public int singleNumber(final List<Integer> A) {

        int ones = 0;
        int twos = 0;
        int mask = 0;

        for (int num : A){
            twos ^= ones&num;
            ones ^= num;
            mask = ~(ones & twos);
            twos &= mask;
            ones &= mask;

        }

        return ones;
    }
}

