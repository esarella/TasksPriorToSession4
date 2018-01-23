package Quiz;

import java.math.BigInteger;

public class CounterGame {

    static void counterGame(String[] tests) {

        for(String test: tests){
            boolean t = false;
            BigInteger n = new BigInteger(test.toString());

            while(!n.equals(BigInteger.ONE)){
                if(n.and(n.subtract(BigInteger.ONE)).equals(BigInteger.ZERO)){
                    n = n.subtract(n.divide(BigInteger.valueOf(2)));
                }
                else{
                    BigInteger x = new BigInteger(n.toString());
                    while(!x.and(x.subtract(BigInteger.ONE)).equals(BigInteger.ZERO)) {
                        x = x.and(x.subtract(BigInteger.ONE));
                    }
                    n = n.subtract(x);
                }
                t = !t;
            }

            if(t){
                System.out.println("Louise");
            }
            else{
                System.out.println("Richard");
            }
        }

    }
}
