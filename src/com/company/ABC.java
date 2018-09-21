package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class ABC {
    private StringBuilder str = new StringBuilder();
    private LinkedList<Character> stack = new LinkedList<>();
    private LinkedList<Character> ans= new LinkedList<>();

    public ABC(){
       Scanner sc = new Scanner(System.in);
       str = new StringBuilder(sc.nextLine());
       stack.add(new Character('!'));
       for(int i = 0 ;i<str.length();i++){
           char c = str.charAt(i);
           char top = stack.getLast();
           if(c =='/' && top =='/'){
               continue;
           }
           if(c == '.' && top =='.'){
               int num = 0;
               while(num<=1){
                   top = stack.getLast();
                   if(top =='/'){
                       num++;
                   }
                   stack.remove(top);
               }
           }
           else{
               stack.addLast(c);
           }
       }
       while(stack.getLast()!= new Character('!')){
           Character top = stack.getLast();
           stack.remove(top);
           if(top== '.'){
               stack.remove(top);
               stack.removeLast();
           }
           else
            ans.add(top);
       }
       while(ans.isEmpty()){
           System.out.print(ans.getLast());
           ans.removeLast();
       }
    }
}
