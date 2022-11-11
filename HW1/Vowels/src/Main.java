import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a line: ");
        String line = in.nextLine();
        countConsonantsAndVowels(line);
    }
    public static void countConsonantsAndVowels(String line) {
        int count = 0;
        line = line.toLowerCase(Locale.ROOT);
        for (int i = 0; i < line.length(); i++) {
             if ((line.charAt(i)=='a') || (line.charAt(i)=='e')
                     || (line.charAt(i)=='i') || (line.charAt(i)=='o') || (line.charAt(i)=='u')) {
                 count++;
             }
        }
        System.out.println("Количество гласных " + count);
        System.out.println("Количество согласных " + (line.length() - count));
    }
}