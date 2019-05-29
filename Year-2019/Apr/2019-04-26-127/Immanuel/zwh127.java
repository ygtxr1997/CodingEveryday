public class Solution {

    //打扰了，runtime 272ms，beats 26.54%
    //isReachable用于判断两个String之间可否直接转换
    // 保存wordList中beginWord可直达的String为beginSet
    // 思路：定义步长这个概念，即距离endWord所需转换的次数
    // 以"hit"，"cog"，["hot","dot","dog","lot","log","cog"]为例
    // "cog"与自己的步长为0
    // 距离"cog"步长为1的是"dog"、"log"
    // 距离"cog"步长为2的是与["dog","log"]步长为1的String，是"dot"，"lot"
    // 以此类推，某一步中若出现beginSet中的String，即得到最短距离
    private boolean isReachable(String pre, String post){
        char[] x1 = pre.toCharArray();
        char[] x2 = post.toCharArray();

        int count = 0;
        for(int i = 0; i < x1.length; i++){
            if(x1[i] != x2[i]){
                if(count == 1) return false;
                else count++;
            }
        }

        if(count == 1)
            return true;
        else
            return false;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.remove(endWord))
            return 0;
        if(isReachable(beginWord, endWord))
            return 2;

        Set<String> beginSet = new HashSet<>();
        for(String tmp: wordList){
            if(isReachable(beginWord, tmp))
                beginSet.add(tmp);
        }
        if(beginSet.isEmpty())
            return 0;


        Set<String> preStep = new HashSet<>();
        preStep.add(endWord);
        int count = 0;
        while (!wordList.isEmpty()){
            Set<String> tmpSet = new HashSet<>();
            for(String tmp: preStep){
                int pos = 0;
                while (pos < wordList.size()){
                    if(isReachable(tmp, wordList.get(pos))){
                        if(beginSet.contains(wordList.get(pos)))
                            return count + 3;
                        tmpSet.add(wordList.remove(pos));
                    }
                    else {
                        pos++;
                    }
                }
            }
            if(tmpSet.isEmpty())
                break;
            count++;
            preStep = tmpSet;
        }
        return 0;
    }
}