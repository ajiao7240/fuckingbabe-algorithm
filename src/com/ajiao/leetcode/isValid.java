package com.ajiao.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 	左括号必须用相同类型的右括号闭合。
 * 	左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串
 *
 */
public class isValid {
    public static void main(String[] args) {
        System.out.println(isValid("([][])"));
    }
    public static boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        //为奇数直接返回false
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        if(stack.empty())
            return true;
        return false;
    }
}
