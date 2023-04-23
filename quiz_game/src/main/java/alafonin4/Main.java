package alafonin4;

import alafonin4.IO.ConsoleInput;
import alafonin4.IO.ConsoleOutput;

public class Main {
    private static void StartGame(Game game) {
        while (true) {
            String command = ConsoleInput.nextCommand();
            if (command.equals("/start")) {
                game.start();
                break;
            } else {
                ConsoleOutput.PrintInConsole("You haven't started the game, " +
                        "so you can't access commands other than /start");
            }
        }
    }
    public static void main(String[] args) {
        Game quiz = new Game();
        ConsoleOutput.PrintInConsole("Welcome to the quiz game!\n" +
                "To start the game, enter the command \"/start\"");
        StartGame(quiz);
        quiz.endGameAndShowStats();
    }
}