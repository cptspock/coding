/**
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	An input string is valid if:

	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
 */
package solutions;

import java.util.Stack;

public class ValidParentheses {
	public boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else {
				if (stack.isEmpty()) // string begins with a closing bracket
					return false;
				char top = stack.pop();
				if ((c == ')' && top == '(') ||
						(c == '}' && top == '{') ||
						(c == ']' && top == '['))
					continue;
				else return false; // closing bracket does not match with opening bracket in stack
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isBalanced("[("));
	}

}
