public class Solution{

    private boolean isValid(String tmp){
        if(tmp.length() > 3|| tmp.length() < 1|| (tmp.charAt(0) == '0'&& tmp.length() > 1)|| Integer.parseInt(tmp) > 255)
            return false;
        return true;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> outPut = new ArrayList();
        if(s.length() < 4|| s.length() > 12)
            return outPut;

        for(int i = 1; i <= 3&& i <= s.length(); i++){
            for(int j = i + 1; j <= i + 3&& j <= s.length(); j++){
                for(int k = j + 1; k <= j + 3&& k <= s.length(); k++){
                    String field1 = s.substring(0, i);
                    String field2 = s.substring(i, j);
                    String field3 = s.substring(j, k);
                    String field4 = s.substring(k, s.length());
                    if(isValid(field1)&& isValid(field2)&& isValid(field3)&& isValid(field4)){
                        StringBuilder tmp = new StringBuilder();
                        tmp.append(field1).append('.').append(field2).append('.').append(field3).append('.').append(field4);
                        outPut.add(tmp.toString());
                    }
                }
            }
        }
        
        return outPut;
    }
}