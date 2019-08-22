class Solution {
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char Sc[] = S.toCharArray();
            Arrays.sort(Sc);
            return new String(Sc);
        }
        String output = S;
        for (int i = 1; i < S.length(); i++) {
            String tmp = S.substring(i) + S.substring(0, i);
            if (output.compareTo(tmp) > 0) output = tmp;
        }
        return output;
    }
}