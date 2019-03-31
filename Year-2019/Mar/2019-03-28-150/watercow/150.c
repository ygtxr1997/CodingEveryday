class Solution {
public:
	int evalRPN(vector<string>& tokens) {
		stack<int> num_stack;
		for (auto i : tokens) {
			if (i == "+") {
				int a = num_stack.top();
				num_stack.pop();
				int b = num_stack.top();
				num_stack.pop();
				num_stack.push(a + b);
			}
			else if (i == "-") {
				int a = num_stack.top();
				num_stack.pop();
				int b = num_stack.top();
				num_stack.pop();
				num_stack.push(b - a);
			}
			else if (i == "*") {
				int a = num_stack.top();
				num_stack.pop();
				int b = num_stack.top();
				num_stack.pop();
				num_stack.push(a * b);
			}
			else if (i == "/") {
				int a = num_stack.top();
				num_stack.pop();
				int b = num_stack.top();
				num_stack.pop();
				num_stack.push(b / a);
			}
			else {
				num_stack.push(atoi(i.c_str()));
			}
		}
		return num_stack.top();
	}
};