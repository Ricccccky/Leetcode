import java.util.*;

/*
 * @lc app=leetcode id=1597 lang=java
 *
 * [1597] Build Binary Expression Tree From Infix Expression
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        Deque<Node> stack = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(new Node(c));
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    stack.push(internalNode(ops.pop(), stack.pop(), stack.pop()));
                }
                ops.pop();
            } else {
                while (!ops.isEmpty() && compareOPS(c, ops.peek())) {
                    stack.push(internalNode(ops.pop(), stack.pop(), stack.pop()));
                }
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            stack.push(internalNode(ops.pop(), stack.pop(), stack.pop()));
        }

        return stack.peek();
    }

    // Return true if op2 has higher priority
    private boolean compareOPS(char op1, char op2) {
        if (op2 == '(') {
            return false;
        }
        return op2 == '*' || op2 == '/' || op1 == '+' || op1 == '-';
    }

    private Node internalNode(char op, Node opd2, Node opd1) {
        return new Node(op, opd1, opd2);
    }
}
// @lc code=end

