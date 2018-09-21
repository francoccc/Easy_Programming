package com.company;

import java.util.*;

public class FindMaxStr_bytedance {
    private int n;
    private LinkedList<Str> list = new LinkedList<>();
    private HashMap<Integer,String> ans = new HashMap<>();
    private int[] visit = new int[30];

    private class Str{
        StringBuilder str;
        int id;

        Str(int id,StringBuilder str){
            this.id = id;
            this.str = str;
        }
    }

    public FindMaxStr_bytedance(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        for(int i = 1;i<=n;i++){
            StringBuilder s = new StringBuilder(sc.nextLine());
            list.addLast(new Str(i,s));
        }
        run();
    }

    private void run(){
        int ind = 0;
        while(!list.isEmpty()){
            Iterator iter = list.listIterator();
            while(iter.hasNext()){
                Str obj = (Str)iter.next();
                visit[obj.str.charAt(ind) - 'a']++;
            }

            iter = list.listIterator();
            ArrayList<Str> objs = new ArrayList<>();
            while(iter.hasNext()){
                Str obj = (Str)iter.next();
                if(visit[obj.str.charAt(ind) - 'a'] == 1){
                    ans.put(new Integer(obj.id),obj.str.substring(0,ind+1));
                    objs.add(obj);
                }
            }
            for(int i = 0;i<objs.size();i++){
                Str obj = objs.get(i);
                list.remove(obj);
            }
        }

        for(int i = 1;i<=n;i++){
            System.out.println(ans.get(new Integer(i)));
        }
    }

}
