package Interviews;

public interface TowersOfHanoiSoln {

    /**
     * All possible moves between rods A, B, and C
     */
    public static enum Move {
        AB, AC, BA, BC, CA, CB;
    }

    /**
     * Solve the sequence of correct moves for n discs from rod A to rod C.
     *
     * @param n - number of discs
     * @return the sequence moves
     */
    Move[] solve(int n);

}
