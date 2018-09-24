package com.company.tencent;
import java.util.Scanner;

import static java.lang.System.out;


public class StringMove {
    public StringMove(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            StringBuilder str = new StringBuilder(sc.nextLine());
            run(str);
        }
    }

    private void run(StringBuilder str){
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <='z'){
                out.append(str.charAt(i));
            }
        }
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <='Z'){
                out.append(str.charAt(i));
            }
        }
        out.append('\n');
    }
}
