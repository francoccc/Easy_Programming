package com.company.tencent;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tuple {
    int n;
    ArrayList<Integer> a = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    int max;
    int ans_min;
    int ans_max = 0;

    public Tuple(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=n;i++){
            a.add(sc.nextInt());
        }
        Collections.sort(a);
        for(int i=1;i<n;i++){
            if(a.get(i) - a.get(i-1) < min){
                min = a.get(i) - a.get(i-1);
                ans_min = 1;
            }
            else if(a.get(i) - a.get(i-1) == min){
                ans_min ++;
            }
        }
        int l = 0, r = n - 1;
        while(true){
            if(a.get(r) == a.get(r-1)){
                r--;
            }
            else if(a.get(l) == a.get(l+1)){
                l++;
            }
            else{
                break;
            }
        }
        ans_max = (l+1) * (n-r);
        System.out.println(ans_min+" "+ans_max);
    }
}
