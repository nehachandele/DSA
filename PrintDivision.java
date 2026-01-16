import java.util.Scanner;

public class PrintDivision {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
    System.out.println("Enter a Number");
        int num=sc.nextInt();

        for(int i=1;i<Math.sqrt(num);i++){
            if(num%i==0){
                System.out.println(i);
                if(i!=num/i){
                    System.out.println(num/i);
                }
            }
        }
    }
}
