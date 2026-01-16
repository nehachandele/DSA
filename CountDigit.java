import java.util.Scanner;

public class CountDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // create Scanner object
        System.out.println("Enter Number");
        int num = sc.nextInt();
        System.out.println("The Total Digit Count is: " + countDigit(num));

    }

    static int countDigit(int n) {
        int count = 0;

        while (n != 0) {

            count += 1;
            n = n / 10;
        }
        return count;
    }
}

//Time Complexity
//Log10 (N) for above code due to N=N/10
//Log5 (N) for above code due to N=N/5 remember the code idea