class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int length;
        List<String> result = new LinkedList<>();
        StringBuffer stringBuffer;
        for (int i = 0; i < words.length; i++) {
            stringBuffer = new StringBuffer();
            //求当前行会有多少个单词
            length = 0;
            int j;
            for (j = i; j < words.length; j++) {
                length += words[j].length();
                if (length == maxWidth){
                    break;
                }
                if (length > maxWidth){
                    length -= words[j].length();
                    length--;
                    j--;
                    break;
                }
                //空格
                length++;
            }
            //判断是否为最后一行
            if (j == words.length){
                for (int k = i; k < words.length; k++) {
                    stringBuffer.append(words[k]+" ");
                }
                for (int k = stringBuffer.length(); k < maxWidth; k++) {
                    stringBuffer.append(" ");
                }
            }else {
                //只有一个单词的时候
                if (i==j){
                    stringBuffer.append(words[i]);
                    for (int k = stringBuffer.length(); k < maxWidth; k++) {
                        stringBuffer.append(" ");
                    }
                }else {
                    //考虑空格
                    int space = maxWidth - length;
                    int spaceNums = space/(j-i);
                    int spaceExtra = space%(j-i);
                    //单词合并
                    for (int k = i; k < j; k++) {
                        stringBuffer.append(words[k]+" ");
                        for (int l = 0; l < spaceNums; l++) {
                            stringBuffer.append(" ");
                        }
                        if (spaceExtra > 0){
                            stringBuffer.append(" ");
                            spaceExtra--;
                        }
                    }
                    stringBuffer.append(words[j]);
                }
            }
            i=j;
            result.add(stringBuffer.toString());
        }
        return result;
    }
}
