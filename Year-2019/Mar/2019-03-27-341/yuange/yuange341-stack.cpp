/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
// 第二种方法用栈+非递归的方式实现，也是题目希望的解法，20ms，100%
// 使用两个栈，一个存放当前遍历位置，另一个存放当前遍历数组的末尾
class NestedIterator {
private:
    stack<vector<NestedInteger>::iterator> cur, tail; 
public:
    NestedIterator(vector<NestedInteger> &nestedList) {
        cur.push(nestedList.begin());
        tail.push(nestedList.end());
    }

    int next() {
        return (cur.top()++)->getInteger();
    }

    bool hasNext() {
        while (!cur.empty()) {
            if (cur.top() == tail.top()) {
                cur.pop(); tail.pop();
            } else {
                auto t = cur.top();
                if (t->isInteger()) return true;
                cur.top()++;
                cur.push(t->getList().begin());
                tail.push(t->getList().end());
            }
        }
        return false;
    }
};

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i(nestedList);
 * while (i.hasNext()) cout << i.next();
 */