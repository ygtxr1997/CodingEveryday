public class Solution {
    public String reverseWords(String s) {
        StringBuilder outPut = new StringBuilder();

        String[] tmp = s.split(" ");
        int begin = 0;
        while (begin < tmp.length&& tmp[begin].equals("")){
            begin++;
        }
        for(int i = tmp.length - 1; i > begin; i--){
            if(!tmp[i].equals("")){
                outPut.append(tmp[i]);
                outPut.append(" ");
            }
        }
        if(begin < tmp.length&& !tmp[begin].equals("")){
            outPut.append(tmp[begin]);
        }

        return outPut.toString();
    }
}