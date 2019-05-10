public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0)
            return true;
        if(s2.length() < s1.length())
            return false;

        int[] map = new int[26];
        for(int i = 0; i < s1.length(); i++){
            map[s1.charAt(i) - 'a']++;
        }

        int pre = 0;
        int post = 0;
        while (post < s2.length()){
            int  tmp = s2.charAt(post) - 'a';
            map[tmp]--;
            if(map[tmp] == 0&& post - pre == s1.length() - 1){
                return true;
            }
            else {
                while (map[tmp] < 0){
                    int tmp1 = s2.charAt(pre++) - 'a';
                    map[tmp1]++;
                }
            }
            post++;
        }

        return false;
    }

//    public boolean checkInclusion(String s1, String s2) {
//        if(s1.length() == 0)
//            return true;
//        if(s2.length() < s1.length())
//            return false;
//
//        Map<Character, Integer> map = new HashMap<>();
//        for(int i = 0; i < s1.length(); i++){
//            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
//        }
//
//        int pre = -1;
//        int post = 0;
//        while (post < s2.length()){
//            char tmp = s2.charAt(post);
//            if(map.containsKey(tmp)){
//                map.put(tmp, map.get(tmp) - 1);
//                if(map.get(tmp) == 0&& post - pre == s1.length()){
//                    return true;
//                }
//                else {
//                    while (map.get(tmp) < 0){
//                        char tmp1 = s2.charAt(++pre);
//                        map.put(tmp1, map.get(tmp1) + 1);
//                    }
//                }
//            }
//            else {
//                while (++pre < post) {
//                    char tmp1 = s2.charAt(pre);
//                    map.put(tmp1, map.get(tmp1) + 1);
//                }
//            }
//            post++;
//        }
//
//        return false;
//    }
}