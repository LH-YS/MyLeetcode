package com.LY.MainTraining;
import java.util.*;
public class C53_ContinuousLetterLength {
    private static class MyChar{
        char value;
        int length;

        public MyChar(char value,int length) {
            this.value = value;
            this.length = length;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int target = scanner.nextInt();
        int res = computeContinuousLetterLength(line,target);
        System.out.println(res);
    }

    private static int computeContinuousLetterLength(String line, int target) {
        PriorityQueue<MyChar> priorityQueue = new PriorityQueue<>(new Comparator<MyChar>() {
            @Override
            public int compare(MyChar o1, MyChar o2) {
                return o2.length - o1.length;
            }
        });
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = line.toCharArray();
        char temp = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==temp){
                sum++;
            }else {
                //对之前的进行结算
                if (map.containsKey(temp)){
                    //保留最大
                    map.put(temp,Math.max(map.get(temp),sum));
                }else {
                    map.put(temp,sum);
                }
                temp = array[i];
                sum = 1;
            }
        }

        //如果sum不为0,最后结算一次
        if (sum!=0){
            if (map.containsKey(temp)){
                //保留最大
                map.put(temp,Math.max(map.get(temp),sum));
            }else {
                map.put(temp,sum);
            }
        }
        if (map.size()<target){
            return 0;
        }
        for (char i:map.keySet()){
            priorityQueue.add(new MyChar(i,map.get(i)));
        }
        int res = 0;
        for (int i = 0; i < target; i++) {
            res = priorityQueue.poll().length;
        }
        return res;
    }
}
