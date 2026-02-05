import java.util.HashMap;
class Solution {
    public int minSwapsCouples(int[] row) {
        int n=row.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int swaps=0;

        for(int i=0;i<n;i++){
            map.put(row[i],i);
        }

        for(int i=0;i<n;i+=2){
            int first=row[i];
            int expectedPartner=(first%2==0)? first+1:first-1;

            if(row[i+1]!=expectedPartner){
                swaps++;

                int partnerIndex=map.get(expectedPartner);

                int temp=row[i+1];
                row[i+1]=row[partnerIndex];
                row[partnerIndex]=temp;

                map.put(temp,partnerIndex);
                map.put(expectedPartner,i+1);
            }
        }
        return swaps;
    }
}