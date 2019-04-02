class Solution {
    private List<List<String>> outPut;
    private List<String> tmp;
    public boolean isPalindrome(String inPut){
        int left = 0;
        int right = inPut.length() - 1;
        while(left < right){
            if(inPut.charAt(left) != inPut.charAt(right))
                return false;
            ++left;
            --right;
        }
        return true;
    }
    private void backTrack(String inPut, int pos){
        if(pos >= inPut.length()){
            outPut.add(new ArrayList(tmp));
            return;
        }
        for(int i = pos + 1; i <= inPut.length(); i++){
            if(isPalindrome(inPut.substring(pos, i))) {
                tmp.add(inPut.substring(pos, i));
                backTrack(inPut, i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        outPut = new ArrayList<>();
        tmp = new ArrayList<>();
        for(int i = 1; i <= s.length(); i++) {
            if(isPalindrome(s.substring(0, i))) {
                tmp.add(s.substring(0, i));
                backTrack(s, i);
                tmp.remove(tmp.size() - 1);
            }
        }
        return outPut;
    }
}