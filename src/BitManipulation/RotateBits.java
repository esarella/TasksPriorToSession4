package BitManipulation;

public class RotateBits {
    public static void main(String[] args) {
        int x = 0X11110000;
        int y = 2;
//        System.out.println(Integer.toBinaryString(rotateBits(x,y)));
        System.out.println(Long.toBinaryString(rotateBits(0x00000000000000000000000000000011)));

    }

    public static int rotateBits(int x , int y){

        int len = Integer.toBinaryString(x).length();
//        return ( x >>> y | x << (32-y));

        return Integer.rotateRight(x, y);


    }

    public static long rotateBits(long a ){
        long reverse = 0;
        for (int i = 0 ; i < 32 ; i++){
            reverse <<= 1;
            if((a & (1 << i)) !=0){
                reverse |=1;
            }
        }
        return reverse;
    }

    }
