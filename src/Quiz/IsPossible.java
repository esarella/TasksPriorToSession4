package Quiz;

public class IsPossible {

    /*
     * Complete the function below.
     */
    static String isPossible(int a, int b, int c, int d) {
        if(isPossibleHelper(a,b,c,d)){
            return "Yes";
        }
        else
            return "No";
    }

    static boolean isPossibleHelper(int a, int b, int c, int d) {
        if(a == c && b == d){
            return true;
        }
        if (a+b <= c || a+b <=d){
            return isPossibleHelper(a+b, b ,c ,d) || isPossibleHelper(a,a+b,c,d);
        }
        return false;
    }


}
