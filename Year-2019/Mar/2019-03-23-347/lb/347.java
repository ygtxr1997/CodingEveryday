import javafx.util.Pair;

import java.util.*;

public class TopKFrequent {
    /**
     * 使用map和PriorityQueue来实
     * map用来计数，优先队列用来按频率次数进行排序
     * 注意comparator中compare函数的使用
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        //使用优先队列需要实现comparator的compare函数才能调用
        Queue<Pair<Integer,Integer>> queue = new PriorityQueue<>(comparator);
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            map.put(i,map.get(i)== null?1:map.get(i)+1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.add(new Pair<>(entry.getKey(),entry.getValue()));
        }
        while (k-->0){
            list.add(queue.poll().getKey());
        }
        return list;
    }

    public Comparator<Pair<Integer,Integer>> comparator = new Comparator<Pair<Integer, Integer>>() {
        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            return o1.getValue() - o2.getValue();//优先pop value值最大的pair
        }
    };
}
