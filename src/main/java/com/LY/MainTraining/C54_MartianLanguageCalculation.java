package com.LY.MainTraining;
import java.util.*;
public class C54_MartianLanguageCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = computeMartianLanguageCalculation(s);
        System.out.println(res);
    }

    private static int computeMartianLanguageCalculation(String s) {
        char[] chars = s.toCharArray();
        int pre = -1;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!='#'&&chars[i]!='$'){
                if (pre==-1){
                    pre=Integer.parseInt(""+chars[i]);
                }else {
                    pre = pre*10+Integer.parseInt(""+chars[i]);
                }
            }else {
                //结算
                arrayList.add(pre+"");
                pre = -1;
                arrayList.add(chars[i]+"");
            }
        }
        //最后再结算一次
        arrayList.add(pre+"");
        String[] array = new String[arrayList.size()];
        int k = 0;
        for (String i:arrayList){
            array[k++] = i;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("#")){
                continue;
            } else if (array[i].equals("$")) {
                int last = list.pollLast();
                int next = Integer.parseInt(array[i+1]);
                int temp = 3*last+next+2;
                list.addLast(temp);
                i++;
            }else {
                list.addLast(Integer.parseInt(array[i]));
            }
        }
        while (!list.isEmpty()&&list.size()>1){
            int x = list.pollFirst();
            int y = list.pollFirst();
            list.addFirst(2*x+3*y+4);
        }
        return list.isEmpty()?0:list.pollFirst();
    }
}
