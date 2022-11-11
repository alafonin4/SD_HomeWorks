import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        factorial(num);
    }

    static void factorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result = result * i;
        }
        System.out.println(result);
    }
}