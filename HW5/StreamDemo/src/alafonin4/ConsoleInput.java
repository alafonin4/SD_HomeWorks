package alafonin4;

import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);
    public ConsoleInput() {}
    public static String inputRequire() {
        String require = scanner.nextLine();

        Pattern pattern = Pattern.compile("require ");
        Matcher matcher = pattern.matcher(require);

        if (matcher.find()) {
            return require;
        } else {
            throw new IllegalArgumentException("Entered string is not a request. Please try again.");
        }
    }
}
