package alafonin4;

import alafonin4.model.User;

import java.util.List;
import java.util.Map;

public class ConsoleOutput {
    public static void PrintList(List<User> users) {
        for (var user:
                users) {
            System.out.println(user.toString());
        }
    }
    public static <T> void PrintLine(T out) {
        System.out.println(out);
    }
    public static void PrintMap(Map<Long, List<User>> usersGroupedById) {
        for (var key : usersGroupedById.keySet()) {
            ConsoleOutput.PrintLine("The following users were found by the key = " + key);
            for (var user : usersGroupedById.get(key)) {
                ConsoleOutput.PrintLine("\t" + user.toString());
            }
        }
    }
}
