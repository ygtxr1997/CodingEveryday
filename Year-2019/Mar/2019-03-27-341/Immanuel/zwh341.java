public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack  = new Stack<>();
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        //hasNext();
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            if(stack.peek().isInteger()){
                return true;
            }
            List<NestedInteger> tmp = stack.pop().getList();
            for(int i = tmp.size() - 1; i >= 0; i--){
                stack.push(tmp.get(i));
            }
        }
        return false;
    }
}