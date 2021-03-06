package medium.question394;

import java.util.Stack;

/**
 * Decode String
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string
 * inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and
 * that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                StringBuilder sb = new StringBuilder();
                while (stack.peek()!='['){
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder Scount = new StringBuilder();
                while (!stack.empty()&&stack.peek()<='9'){
                    Scount.append(stack.pop());
                    Scount.reverse();
                }
                int count = Integer.valueOf(Scount.toString());
                for(int j=0;j<count;j++){
                    for(int k=sb.length()-1;k>=0;k--){
                        stack.push(sb.charAt(k));
                    }
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.println(new Solution().decodeString(s));
    }
}
