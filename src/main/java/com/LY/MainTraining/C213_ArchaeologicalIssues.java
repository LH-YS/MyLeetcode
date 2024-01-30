package com.LY.MainTraining;
import java.io.*;
import java.util.*;
public class C213_ArchaeologicalIssues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        ArrayList<String> res = computeArchaeologicalIssues(str);
        for(String i:res){
            System.out.println(i);
        }
    }

    private static ArrayList<String> computeArchaeologicalIssues(String[] str) {
        HashSet<String> res = new HashSet<>();
        int[] used = new int[str.length];
        process(str,used,res,"",0);
        ArrayList<String> list = new ArrayList<>();
        for (String i:res){
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }

    private static void process(String[] str, int[] used, HashSet<String> res, String sub, int index) {
        if (index==str.length){
            res.add(sub);
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (used[i]!=1){
                //说明没用过
                used[i] = 1;
                process(str,used,res,sub+str[i],index+1);
                used[i] = 0;
            }
        }
    }
}
