package Quiz;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    static void pascalTriangle(int k) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <=i; j++){
                if (j == 0){
                    row.add(1);
                }
                else if (j < i ){
                    int x = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    row.add(x);
                }
                else if (j ==i){
                    row.add(1);
                }
            }
            result.add(row);
        }
        printPascalsTriangle(result);
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
