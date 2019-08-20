class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() % 2 == 1)
            return false;

        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(stack.isEmpty() || tmp == '(' || tmp == '[' || tmp == '{'){
                stack.offerLast(tmp);
            }
            else if((tmp == ')' && stack.peekLast() == '(') || (tmp == ']' && stack.peekLast() == '[') || (tmp == '}' && stack.peekLast() == '{')){
                stack.pollLast();
            }
            else 
                return false;
        }

        return stack.isEmpty();
    }
}