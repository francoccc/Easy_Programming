package com.company;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DFSChar_bytedance {
    private int  m,n,k;
    private String str;
    private String[] strs;
    private String[] zimus;
    private ArrayList<ArrayList<Point>> map = new ArrayList<>();
    private String[] Map = new String[10001];
    private StringBuilder[] Visit = new StringBuilder[10001];
    private int[] dx = {1,0,0,-1};
    private int[] dy = {0,1,-1,0};

    private class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public DFSChar_bytedance(){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        str =  sc.nextLine();
        strs = str.split(" ");
        for(int i=0;i<26;i++){
            map.add(new ArrayList<Point>());
        }

        for(int i=1;i<=n;i++){
            str = sc.nextLine();
            zimus = str.split(" ");
            Map[i]=" ";
            Visit[i]=new StringBuilder(" ");
            for(int j=1;j<=m;j++){
                char c = zimus[j-1].charAt(0);
                Map[i]+=c;
                Visit[i].append('0');
                int index = c - 'a';
                map.get(index).add(new Point(i, j));
            }
        }

        run();
    }

    private boolean dfs(int x,int y,String string,int i){
        if(string.charAt(i) != Map[x].charAt(y)){
            return false;
        }
        else if(i == string.length()-1){
            if(Map[x].charAt(y)== string.charAt(i)){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            boolean flag = false;
            for(int j=0;j<4;j++){
                int xx = x +dx[j];
                int yy = y +dy[j];
                if(xx < 1 || yy<1 || xx>n || yy>m) continue;
                if(Visit[xx].charAt(yy)=='0'){
                    Visit[xx].setCharAt(yy,'1');
                    flag |= dfs(xx,yy,string,i+1);
                    Visit[xx].setCharAt(yy,'0');
                }
            }
            return flag;
        }
    }

    private boolean check(String string){
        boolean flag = false;
        char c = string.charAt(0);
        int index = c-'a';
        Iterator iter = map.get(index).iterator();
        while(iter.hasNext()){
            Point p = (Point)iter.next();
            Visit[p.x].setCharAt(p.y,'1');
            flag |= dfs(p.x,p.y,string,0);
            Visit[p.x].setCharAt(p.y,'0');
            if(flag == true) break;
        }
        return flag;
    }

    private void run(){
        for(String string : strs){
            if(check(string)) {
                System.out.println(string);
            }
        }
    }
}
