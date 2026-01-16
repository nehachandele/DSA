import java.util.Scanner;

public class ArmstrongNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number to check Palindrome:");
        int num = sc.nextInt();
        if (isArmstrong(num)) {
            System.out.println(num + " is a Armstrong Number");
        } else {
            System.out.println(num + " is not a Armstrong Number");
        }
    }

    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum = sum + digit * digit * digit;
            num = num / 10;
        }
        return originalNum == sum;
    }
}
