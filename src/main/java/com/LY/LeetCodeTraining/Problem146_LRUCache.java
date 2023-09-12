package com.LY.LeetCodeTraining;

import java.util.HashMap;
import java.util.LinkedList;

public class Problem146_LRUCache {
    class LRUCache {

        int size = 0;
        int capacity;
        LinkedList<Integer> list;
        HashMap<Integer, Integer> map;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (size==0){
                return -1;
            }
            if (!map.containsKey(key)){
                return -1;
            }
            LinkedList<Integer> temp = new LinkedList<>();
            int res = -1;
            while (list.peek()!=null){
                if (list.peek()==key){
                    res = list.removeFirst();
                }else {
                    temp.addLast(list.removeFirst());
                }
            }
            list = temp;
            list.addLast(res);
            return map.get(res);
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)){
                if (size==capacity){
                    map.remove(list.peek());
                    list.removeFirst();
                }
                map.put(key,value);
                list.addLast(key);
                size++;
            }
            LinkedList<Integer> temp = new LinkedList<>();
            int res = -1;
            while (list.peek()!=null){
                if (list.peek()==key){
                    map.put(key,value);
                    res = list.removeFirst();
                }else {
                    temp.addLast(list.removeFirst());
                }
            }
            list = temp;
            list.addLast(res);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
