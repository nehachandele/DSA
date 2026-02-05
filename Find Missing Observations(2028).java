class Solution {
       public int[] missingRolls(int[] arr, int mean, int n) {
        var sum = 0;
        for (var num:arr) sum+=num;
        
        var mrs = mean*(arr.length+n)-sum; //missing rolls sum
        if (mrs<n||mrs>n*6) return new int[0]; 
        
        var res = new int[n];
        var equalPart = mrs/n;
        for (int i=0;i<res.length;i++){ //spreading the equal part 
            res[i]=equalPart; mrs-=equalPart;
        }
        for (int i=0;mrs!=0;i++){ //spreading the rest
            res[i]++; mrs--;
        }
        return res;
    }
}