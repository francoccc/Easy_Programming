package com.company;

import com.company.tencent.ReverseString;
import com.company.tencent.StringMove;
import com.company.tencent.Tuple;

/**
 * Author franco
 * the next will be better
 */

public class Main {
    private int num = 0;
    public int reverse(int a,int j){
        if(a==0){
            return 0;
        }
        else{
            num++;
            int b = a % 10;
            return reverse(a/10,j+1) + (int)Math.pow(10,num-j)*b;
        }
    }

    Main(){
        int a = 12345;
        a = reverse(a,1);
        System.out.println(a);
    }

    public static void main(String[] args) {
        // write your code here
        Tuple t = new Tuple();
    }
}
