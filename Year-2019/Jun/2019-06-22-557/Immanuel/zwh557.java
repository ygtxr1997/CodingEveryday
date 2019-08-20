class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        if(words.length == 0)
            return "";

        StringBuilder wordsReverse = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            wordsReverse.append(new StringBuilder(words[i]).reverse().append(" "));
        }
        wordsReverse.deleteCharAt(wordsReverse.length() - 1);
        
        return wordsReverse.toString();
    }
}