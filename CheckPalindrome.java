import java.util.Scanner;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number to check Palindrome:");
        int num=sc.nextInt();
        if(isPalindrome(num)){
            System.out.println(num+" is a Palindrome Number");
        }else{
              System.out.println(num+" is not a Palindrome Number");
        }
    }
    public static boolean isPalindrome(int num){
        int originalNum=num;
        int reverse=0;
        while(num!=0){
            int digit=num%10;
            reverse=reverse*10+digit;
            num=num/10;
        }
        return originalNum==reverse;
    }
}
