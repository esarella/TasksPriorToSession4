/*
Consider the following interface:

interface SubstringProvider {
  java.util.Collection<String> getSubstrings(String s);
}
Write two implementations of this interface: one using an iterative algorithm and the other using a recursive algorithm.

Example: Given the input string 12345, the output of the program would contain the following strings:

[1, 12, 123, 1234, 12345, 2, 23, 234, 2345, 3, 34, 345, 4, 45, 5]
 */
package Challenges;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface SubstringProvider {
    java.util.Collection<String> getSubstrings(String s);
}


public class ComputeAllSubStrings implements SubstringProvider {
    public static void main(String[] args) {
        ComputeAllSubStrings test = new ComputeAllSubStrings();
        System.out.println(test.getSubstrings("12345"));
    }

//    @Override
//    public Collection<String> getSubstrings(String s) {
//        Collection<String> subStringsList = new ArrayList<>();
//        subStringsList.add("");
//        for (int i = 0 ; i< s.length(); i++){
//            char c = s.charAt(i);
//            Collection<String> newString = new ArrayList<>();
//            for(String x : subStringsList){
//                newString.add(x + c);
//            }
//            subStringsList.addAll(newString);
//        }
//        return subStringsList;
//    }

    //Iterative
    @Override
    public Collection<String> getSubstrings(String s) {
        List<String> result = new ArrayList<>();

        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            StringBuilder sBuilder = new StringBuilder();
            for (int j = i; j < sLength; j++) {
                sBuilder.append(s.charAt(j));
                result.add(sBuilder.toString());
            }
        }

        return result;
    }


}
