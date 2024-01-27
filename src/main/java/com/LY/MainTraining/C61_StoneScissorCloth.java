package com.LY.MainTraining;
import java.util.*;
public class C61_StoneScissorCloth {
    private static class Player{
        String id;
        String type;
        public Player(String id,String type){
            this.id = id;
            this.type = type;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        while (scanner.hasNext()){
            String id = scanner.next();
            String type = scanner.next();
            players.add(new Player(id,type));
        }
        ArrayList<Player> res = computeStoneScissorCloth(players);
        Collections.sort(res, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                int len = 0;
                while (len<o1.id.length()||len<o2.id.length()){
                    if (o1.id.charAt(len) != o2.id.charAt(len)){
                        return o1.id.charAt(len) - o2.id.charAt(len);
                    }
                }
                //如果比到某一个超出界限还相同，就输出小的那个
                return o1.id.length() - o2.id.length();
            }
        });
        if (res!=null) {
            for (Player i : res) {
                System.out.println(i.id);
            }
        }else {
            System.out.println("NULL");
        }
    }

    private static ArrayList<Player> computeStoneScissorCloth(ArrayList<Player> players) {
        ArrayList<Player> Aplayers = new ArrayList<>();
        ArrayList<Player> Bplayers = new ArrayList<>();
        ArrayList<Player> Cplayers = new ArrayList<>();
        for (Player i:players){
            if (i.type.equals("A")){
                Aplayers.add(i);
            } else if (i.type.equals("B")) {
                Bplayers.add(i);
            }else {
                Cplayers.add(i);
            }
        }
        //根据三种选手的分类情况判断胜负
        if (Aplayers.size()==0){
            //如果只有BC两种，判断是否还有一种是空的，如果是就输出null，否则输出所有的B
            if (Bplayers.size()==0||Cplayers.size()==0){
                return null;
            }else {
                return Bplayers;
            }
        }else if (Bplayers.size()==0){
            if (Aplayers.size()==0||Cplayers.size()==0){
                return null;
            }else {
                return Cplayers;
            }
        }else if (Cplayers.size()==0){
            if (Aplayers.size()==0||Bplayers.size()==0){
                return null;
            }else {
                return Aplayers;
            }
        }
        //如果三种都有人那就返回null
        return null;
    }
}
