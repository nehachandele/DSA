import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                st.push(ch);
            }else if(st.size()>0 && st.peek()=='(' && ch==')'){
                st.pop();
            }else if(st.size()>0 && st.peek()=='[' && ch==']'){
                st.pop();
            }else if(st.size()>0 && st.peek()=='{' && ch=='}'){
                st.pop();
            }else{
                return false;
            }
        }
        if(st.size()>0){
            return false;
        }else{
return true;
        }
        
    }
}
/* 
//2ms
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || c != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }
}*/

/**
stack
add, ), ], }

 */

/* 
//1ms
class Solution {
    public boolean isValid(String s) {
        char[] arr=new char[s.length()];
        int top=-1;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                arr[++top]=ch;
            }else{
                if(top==-1)
                  return false;
                char open=arr[top--];
                if(ch==')'&&open!='(') return false;
                if(ch=='}'&&open!='{') return false;
                if(ch==']'&&open!='[') return false;
            }
        }
        return top==-1;
    }
}*/