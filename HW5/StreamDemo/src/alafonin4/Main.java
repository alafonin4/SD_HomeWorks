package alafonin4;

import alafonin4.model.Group;

import java.util.*;

public class Main {

    public static Random random = new Random();

    public static void main(String[] args) {

        Group group = new Group(random.nextInt(30), random);
        var users = group.getUsers();
        String requirement = "";
        ConsoleOutput.PrintLine("Enter request: ");
        while (true) {
            while (true) {
                try {
                    requirement = ConsoleInput.inputRequire();
                } catch (IllegalArgumentException iAE) {
                    ConsoleOutput.PrintLine(iAE.getMessage());
                    continue;
                }
                break;
            }
            boolean flag = true;
            switch (requirement) {
                case "require 1" : var usersSortedByAge = Operations.getSortedUsersByAge(users);
                    ConsoleOutput.PrintList(usersSortedByAge);
                    break;
                case "require 2" : var usersGroupedById = Operations.getUsersGroupedById(users);
                    ConsoleOutput.PrintMap(usersGroupedById);
                    break;
                case "require 3" : int countOfNationality = Operations.getCountOfNationality(users);
                    ConsoleOutput.PrintLine(countOfNationality);
                    break;
                case "require 4" : var usersOver10 = Operations.getOver10(users);
                    ConsoleOutput.PrintList(usersOver10);
                    break;
                case "require exit" : flag = false;
                    break;
                default: ConsoleOutput.PrintLine("Your require do not exist.");
            }
            if (!flag) {
                break;
            }
        }
    }
}