class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new LinkedList<>();

        int pre = 0, post = 0;
        while (post < words.length){
            int sumLen = 0;
            //计算每一行能放下单词的个数：post - pre
            while (post < words.length && sumLen + words[post].length() <= maxWidth){
                sumLen += (words[post++].length() + 1);
            }
            //进行末行计算
            if(post == words.length)
                break;
            StringBuilder tmp = new StringBuilder(words[pre]);
            //仅有两个单词的情况
            if(post - pre == 1){
                for(int i = maxWidth - words[pre].length(); i > 0; i--){
                    tmp.append(" ");
                }
            }
            //多个单词的情况
            else {
                //确定单词间隙的空格数：spaces
                sumLen -= (post - pre);
                int spaces = (maxWidth - sumLen) / (post - pre - 1);
                //确定需要补一个空格的间隙数：sumLen
                sumLen = (maxWidth - sumLen) % (post - pre - 1);
                for(int i = 1; pre + i < post; i++){
                    for(int j = 0; j < spaces; j++){
                        tmp.append(" ");
                    }
                    if(i <= sumLen)
                        tmp.append(" ");
                    tmp.append(words[pre + i]);
                }
            }
            output.add(tmp.toString());
            pre = post;
        }
        //末行计算
        StringBuilder tmp = new StringBuilder(words[pre]);
        int sumLen = words[pre].length();
        for(int i = pre + 1; i < post; i++){
            tmp.append(" ");
            tmp.append(words[i]);
            sumLen += (words[i].length() + 1);
        }
        for(int i = sumLen; i < maxWidth; i++){
            tmp.append(" ");
        }
        output.add(tmp.toString());

        return output;
    }
}