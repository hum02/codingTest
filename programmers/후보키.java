package programmers;

import java.util.*;

class Solution {
    static public int cols, row, res;
    static public boolean visited [];
    static public String [][] rela;
    static public ArrayList<String> list;

    public int solution(String[][] relation) {

        res = 0;
        cols = relation[0].length; // column 갯수
        row = relation.length; // row 갯수
        boolean [] isUnique = new boolean[cols];
        visited = new boolean[cols];
        list = new ArrayList<String>();

        rela = relation.clone();
        combination(0);
        test();

        return res;
    }

    public static void combination(int n){
        if(cols==n){
            makeSet();
            return;
        }
        visited[n] = true;
        combination(n+1);
        visited[n] = false;
        combination(n+1);
    }

    public static void makeSet(){
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i<row; i++){
            String str = "";
            for(int j=0; j<cols; j++){
                if(visited[j]){
                    str += rela[i][j];
                }
            }
            set.add(str);
        }
        if(set.size()==row) {
            // 최소성 판별
            String str  = "";
            for(int i=0; i<cols; i++){
                if(visited[i]) str+="1";
                else str += "0";
            }
            list.add(0,str);
        }
    }


    public static void test(){

        while(list.size()!=0){
            String str = list.get(0);

            for(int i=list.size()-1; i>=1; i--){
                String temp = list.get(i);
                String same = "";
                for(int k = 0; k<cols; k++){
                    if(str.charAt(k)==temp.charAt(k)){
                        same += String.valueOf(str.charAt(k));
                    }
                    else same +="0";
                }
                if(same.equals(temp) || same.equals(str)) {
                    list.remove(i);
                }
            }

            res++;
            list.remove(0);

        }

    }
}

