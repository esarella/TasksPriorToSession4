/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.

Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        res.add(temp);
        createSubsets(res, temp, A, 0);

        return res;
    }

    public static void createSubsets(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, ArrayList<Integer> a, int index)
    {
        for(int i = index;i < a.size(); i++)
        {
            if( i > index && a.get(i) == a.get(i-1))
            {
                continue;
            }
            temp.add(a.get(i));
            res.add(new ArrayList<Integer>(temp));
            createSubsets(res, temp, a, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
