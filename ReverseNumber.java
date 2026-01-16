public class ReverseNumber {
    public static int reverseNumber(int num) {
      int reverse=0;
      while(num!=0){
        int digit=num%10;
        reverse=reverse*10+digit;
        num=num/10;

      }
      return reverse;

    }
    
    public static void main(String[] args) {
        System.out.println(reverseNumber(12345));   // Output: 54321
        System.out.println(reverseNumber(-12345));  // Output: -54321
        System.out.println(reverseNumber(1000));    // Output: 1
    }
}