//用lamada表达式会慢一些，评论区解释如下
// ruanxuyi's avatar
// ruanxuyi
// 16
// October 10, 2018 2:59 AM

// Read More
// @user4135e the overhead of lambda expression in Leetcode comes from the first-time initialization. Lambda bytecode is generated at runtime, while self-defined comparator is created at compile time. Hence, the time spent for lambda's initialization count into your overall performance. ref: https://stackoverflow.com/questions/34585444/java-lambdas-20-times-slower-than-anonymous-classes


public class Solution {
    
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        
//         Arrays.sort(asStrs, (x1, x2) ->{
//             String s1 = x1 + x2;
//             String s2 = x2 + x1;
//             return s2.compareTo(s1);
//         });
        Arrays.sort(asStrs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s2.compareTo(s1);
            }
        });

        if (asStrs[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder outPut = new StringBuilder();
        for (String tmp : asStrs) {
            outPut.append(tmp);
        }

        return outPut.toString();
    }
    
}