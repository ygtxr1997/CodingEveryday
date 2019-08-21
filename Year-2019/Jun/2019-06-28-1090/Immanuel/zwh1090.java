class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        if(values.length < 1)
            return 0;

        int[][] pair = new int[values.length][2];
        for(int i = 0; i < pair.length; i++){
            pair[i][0] = values[i];
            pair[i][1] = labels[i];
        }
        Arrays.sort(pair, (x1, x2) -> x2[0] - x1[0]);

        Map<Integer, Integer> count = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < pair.length && num_wanted > 0; i++){
           if(count.getOrDefault(pair[i][1], 0) < use_limit) {
               sum += pair[i][0];
               count.put(pair[i][1], count.getOrDefault(pair[i][1], 0) + 1);
               num_wanted--;
           }
        }

        return sum;
    }
    
//     public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
//         if(values.length < 1)
//             return 0;
//         //先按label后按values进行递减排序
//         quicksort(values, labels, 0, values.length - 1);
//         //获取候选数字，即各个label中最大的use_limit个数
//         List<Integer> candidate = new ArrayList<>();
//         int index = 0;
//         int lab = labels[index];
//         int times = 0;
//         while (index < values.length){
//             if(labels[index] == lab){
//                 if(times < use_limit){
//                     candidate.add(values[index]);
//                     times++;
//                 }
//                 index++;
//             }
//             else {
//                 lab = labels[index];
//                 times = 0;
//             }
//         }
//         //对候选数字进行排序后，计算前num_wanted个数字的和
//         Collections.sort(candidate, (o1, o2) -> o2 - o1);
//         int sum = 0;
//         for(int i = 0; i < num_wanted && i < candidate.size(); i++){
//             sum += candidate.get(i);
//         }

//         return sum;
//     }
    
//     //快速排序
//     private boolean compare(int label1, int label2, int value1, int value2){
//         if(label1 != label2){
//             return label1 > label2;
//         }
//         else {
//             return value1 > value2;
//         }
//     }

//     private void quicksort(int[] values, int[] labels, int begin, int end){
//         if(begin >= end || begin < 0 || end >= values.length)
//             return;

//         int left = begin, right = end;
//         int pivotValue = values[left];
//         int pivotLabel = labels[left];
//         while (left < right){
//             while (compare(pivotLabel, labels[right], pivotValue, values[right]) && left < right) right--;
//             if(left < right){
//                 labels[left] = labels[right];
//                 values[left++] = values[right];
//             }
//             while (!compare(pivotLabel, labels[left], pivotValue, values[left]) && left < right) left++;
//             if(left < right){
//                 labels[right] = labels[left];
//                 values[right--] = values[left];
//             }
//         }
//         values[left] = pivotValue;
//         labels[left] = pivotLabel;

//         quicksort(values, labels, begin, left - 1);
//         quicksort(values, labels, left + 1, end);
//     }
}