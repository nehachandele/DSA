import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int newStart=newInterval[0];
        int newEnd=newInterval[1];

        for(int interval[]:intervals){
            if(interval[1]<newStart){
                res.add(interval);
            }else if(interval[0]>newEnd){
                res.add(new int[]{newStart,newEnd});
                newStart=interval[0];
                newEnd=interval[1];
            }else {
                newStart=Math.min(newStart,interval[0]);
                newEnd=Math.max(newEnd,interval[1]);
            }
        }
        res.add(new int[]{newStart,newEnd});
        return res.toArray(new int[res.size()][]);

    }
}