package alafonin4.IO;

import java.util.Scanner;

public class ConsoleInput {
    private static Scanner sc = new Scanner(System.in);
    public static String nextCommand() {
        return sc.nextLine();
    }
}
