class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> Valst;
    stack<int> Minst;
    MinStack() {

    }
    
    void push(int x) {
        Valst.push(x);
        if (Minst.empty()) Minst.push(x); // 判空
        else Minst.push(min(Minst.top(), x));
    }
    
    void pop() {
        Valst.pop();
        Minst.pop();
    }
    
    int top() {
        return Valst.top();
    }
    
    int getMin() {
        return Minst.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */