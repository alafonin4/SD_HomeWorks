package alafonin4;

import alafonin4.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Operations {
    public static List<User> getSortedUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparingDouble(User::getAge))
                .toList();
    }
    public static Map<Long, List<User>> getUsersGroupedById(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getId));
    }
    public static List<User> getOver10(List<User> users) {
        return users.stream()
                .filter(user -> (user.getAge() > 10 ))
                .filter(user -> !user.getFirstName().startsWith("M"))
                .toList();
    }
    public static int getCountOfNationality(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getNationality))
                .keySet().size();
    }
}
