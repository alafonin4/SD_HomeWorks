package alafonin4;

import alafonin4.IO.ConsoleInput;
import alafonin4.IO.ConsoleOutput;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Game {
    private static final String API_URL = "http://jservice.io/api/random?count=1";
    private int score;
    private int correctAnswers;
    private int incorrectAnswers;
    private static Logger logger = LoggerFactory.getLogger(Game.class);
    public Game() {
    }

    public void start() {
        score = 0;
        correctAnswers = 0;
        incorrectAnswers = 0;
        play();
    }

    private void play() {
        int numberOfQuestion = 1;
        while (true) {
            JSONObject question = getQuestion();
            String questionText = question.getString("question");
            String answer = question.getString("answer");

            ConsoleOutput.PrintInConsole("Question #" + numberOfQuestion + ": " + questionText);
            String userAnswer = ConsoleInput.nextCommand();

            if (userAnswer.equals("/q")) {
                break;
            }

            if (userAnswer.equalsIgnoreCase(answer)) {
                ConsoleOutput.PrintInConsole("Correct!");
                score += question.getInt("value");
                correctAnswers++;
            } else {
                ConsoleOutput.PrintInConsole("Incorrect! Right answer: " + answer);
                score -= question.getInt("value");
                incorrectAnswers++;
            }
            numberOfQuestion++;
        }
    }

    private JSONObject getQuestion() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = in.readLine();
                JSONArray results = new JSONArray(response);
                JSONObject question = results.getJSONObject(0);
                return question;
            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                logger.error("Error with code " + responseCode + "on HTTP request: " + API_URL);
            } else if (responseCode == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                logger.error("Server error with code: " + responseCode);
                ConsoleOutput.PrintInConsole("The server is not responding at the moment, try again later.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
        return null;
    }
    public void endGameAndShowStats() {
        ConsoleOutput.PrintInConsole("The game is over!");
        ConsoleOutput.PrintInConsole("Number of correct answers: " + correctAnswers);
        ConsoleOutput.PrintInConsole("Number of incorrect answers: " + incorrectAnswers);
        ConsoleOutput.PrintInConsole("Your score: " + score);
    }
}
