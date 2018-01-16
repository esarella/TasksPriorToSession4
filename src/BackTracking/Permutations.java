package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A.size() == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        Integer n = A.remove(0);

        ArrayList<ArrayList<Integer>> subResult = permute(A); //get the permutation for sub list

        for (List<Integer> each : subResult) {
            for (int index = 0; index <= each.size(); index++) {
                ArrayList<Integer> dest = new ArrayList<>(each); //make a copy of original list
                dest.add(index, n); //insert the number into all possible positions
                result.add(dest);
            }
        }
        return result;
    }
}

