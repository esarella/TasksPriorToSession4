package Interviews;

public class TowersOfHanoi implements TowersOfHanoiSoln {

    private static void solve(int n, Move[] moves, int resultIndex, char src, char aux, char dest) {
        if (n == 0) return;

        solve(n - 1, moves, resultIndex, src, dest, aux);
        System.out.println("Moving disk " + n + " from " + src + " to " + dest);
        moves[resultIndex++] = getMove(src, dest);
        solve(n - 1, moves, resultIndex, aux, src, dest);
    }

    private static Move getMove(char src, char dest) {
        if (src == 'A' && dest == 'B') return Move.AB;
        if (src == 'A' && dest == 'C') return Move.AC;
        if (src == 'B' && dest == 'A') return Move.BA;
        if (src == 'B' && dest == 'C') return Move.BC;
        if (src == 'C' && dest == 'A') return Move.CA;
        if (src == 'C' && dest == 'B') return Move.CB;
        return null;
    }

    public static void main(String[] args) {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        System.out.println("*************************");
        towersOfHanoi.solve(1);
        System.out.println("*************************");
        towersOfHanoi.solve(2);
        System.out.println("*************************");
        towersOfHanoi.solve(3);
        System.out.println("*************************");
        towersOfHanoi.solve(4);
        System.out.println("*************************");
        towersOfHanoi.solve(5);
        System.out.println("*************************");
        towersOfHanoi.solve(50);
    }

    /**
     * Solve the sequence of correct moves for n discs from rod A to rod C.
     *
     * @param n - number of discs
     * @return the sequence moves
     */
    @Override
    public Move[] solve(int n) {
        Move[] moves = new Move[(1 << n) - 1];
        solve(n, moves, 0, 'A', 'B', 'C');
        return moves;
    }
}
