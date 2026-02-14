class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> min;
    public MinStack() {
        st=new Stack<>();
        min=new Stack<>();
        
    }
    
    public void push(int val) {
        if(st.size()==0 || min.peek()>=val){
            min.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        int ele1=st.pop();
        int ele2=min.peek();
        if(ele1==ele2){
            min.pop();
        }
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        return min.peek();
    }
}


class MinStack {
    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(0L);
            min = val;
        } else {
            st.push(val - min);
            if (val < min) {
                min = val;
            }
        }
    }

    public void pop() {
        long diff = st.pop();
        if (diff < 0) {
            min = min - diff;
        }
    }

    public int top() {
        long diff = st.peek();
        if (diff > 0) {
            return (int)(min + diff);
        }
        return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}
