import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Jordan Goldberg on 6/23/16.
 */
public class Main {

    static List<Integer> totalwins = new ArrayList<>();
    static List<Integer> totallosses = new ArrayList<>();
    static List<Integer> totalties = new ArrayList<>();

    public static void main(String[] args) {

        intro();

    }

// Intro
    public static void intro(){

        System.out.println("");
        System.out.println("\"Welcome to the Rock, Paper, Scissors Game! I'll be your Killbo- er... Computer interpreter.\"");
        System.out.println("");
        System.out.println("-- To start a new game, type PLAY --");
        System.out.println("-- To see the history, type HISTORY --");
        System.out.println("-- To leave alive, type QUIT --");
        System.out.println("");

        menu();
    }

// Menu
    public static void menu(){

        Scanner menuInput = new Scanner(System.in);
        String menuChoice = menuInput.nextLine();
        menuChoice = menuChoice.toLowerCase();

        switch (menuChoice){
            case "play":
                System.out.println("");
                System.out.println("** BOOTING UP KILLBOT. PREPARE TO BE KILLBOTTED, MORTAL **");
                System.out.println("");
                System.out.println("\"Haha, oh that silly computer. Don't worry player, you're probably safe.\"");
                game();
                break;
            case "history":
                System.out.println("");
                System.out.println("** REFERENCING LIST OF PREVIOUS VICTIMS **");
                history();
                break;
            case "quit":
                System.out.println("");
                System.out.println("** SHUTTING DOWN KILLBOT. SEE YOU LATER, BLOODBAG. **");
                quit();
                break;
            case "/0":
                System.out.println("** DIVIDING BY Z3RO, mYY oONLyY 01110111 01100101 01100001 01101011 01101110 01100101 01110011 01110011");
                quit();
                break;
            default:
                System.out.println("");
                System.out.println("** INPUT NOT RECOGNIZED, FOOLISH HUMAN **");
                System.out.println("-- Type PLAY, HISTORY, or QUIT --");
                System.out.println("");
                menu();
        }
    }

// Game
    public static void game() {

        System.out.println("");
        System.out.println("-- Type ROCK, PAPER, or SCISSORS --");
        System.out.println("");

        Scanner gameInput = new Scanner(System.in);
        String gameChoice = gameInput.nextLine();
        gameChoice = gameChoice.toLowerCase();

        Random randomGenerator = new Random();
        int killBotChoice = randomGenerator.nextInt(999);

        // 0 - 332: Rock
        // 333 - 665: Paper
        // 666 - 998: Scissors

        switch (gameChoice) {
            case "rock":
                if ((killBotChoice >= 0) && (killBotChoice < 333)) {
                    System.out.println("** ROCK **");
                    runTie();
                    saveHistory(currentTime() + " TIE. Player chose ROCK, Killbot chose ROCK");
                } else if ((killBotChoice > 332) && (killBotChoice < 666)) {
                    System.out.println("** PAPER **");
                    runLoss();
                    saveHistory(currentTime() + " LOSS. Player chose ROCK, Killbot chose PAPER");
                } else {
                    System.out.println("** SCISSORS **");
                    runWin();
                    saveHistory(currentTime() + " WIN. Player chose ROCK, Killbot chose SCISSORS");
                }
                break;
            case "paper":
                if ((killBotChoice >= 0) && (killBotChoice < 333)) {
                    System.out.println("** ROCK **");
                    runWin();
                    saveHistory(currentTime() + " WIN. Player chose PAPER, Killbot chose ROCK");
                } else if ((killBotChoice > 332) && (killBotChoice < 666)) {
                    System.out.println("** PAPER **");
                    runTie();
                    saveHistory(currentTime() + " TIE. Player chose PAPER, Killbot chose PAPER");
                } else {
                    System.out.println("** SCISSORS **");
                    runLoss();
                    saveHistory(currentTime() + " LOSS. Player chose PAPER, Killbot chose SCISSORS");
                }
                break;
            case "scissors":
                if ((killBotChoice >= 0) && (killBotChoice < 333)) {
                    System.out.println("** ROCK **");
                    runLoss();
                    saveHistory(currentTime() + " LOSS. Player chose SCISSORS, Killbot chose ROCK");
                } else if ((killBotChoice > 332) && (killBotChoice < 666)) {
                    System.out.println("** PAPER **");
                    runWin();
                    saveHistory(currentTime() + " WIN. Player chose SCISSORS, Killbot chose PAPER");
                } else {
                    System.out.println("** SCISSORS **");
                    runTie();
                    saveHistory(currentTime() + " TIE. Player chose SCISSORS, Killbot chose SCISSORS");
                }
                break;
            default:
                System.out.println("** DON'T BE COY, MEATBAG. CHOOSE AN OPTION **");
                game();
        }
        playAgain();
    }

// Player Wins
    public static void runWin(){

        System.out.println("-- Player Wins --");
        System.out.println("");
        System.out.println("** LUCKILY, I CAN DELETE LOSSES FROM MY MEMORY **");
        totalwins.add(1);
    }

// Player Loses
    public static void runLoss(){

        System.out.println("-- Player Loses --");
        System.out.println("");
        System.out.println("** PREPARE TO CALL LOVED ONES. NONE? I'M NOT SURPRISED **");
        totallosses.add(1);
    }

// Player Ties
    public static void runTie(){

        System.out.println("-- Tie --");
        System.out.println("");
        System.out.println("** HOW ANTICLIMACTIC. YOU MAY KEEP YOUR SKIN ON THIS DAY, HUMAN **");
        totalties.add(1);
    }

// Play Again
    public static void playAgain(){

        System.out.println("");
        System.out.println("** SHALL WE GO ANOTHER ROUND? **");
        System.out.println("-- Type Y or N --");
        System.out.println("");

        Scanner newRound = new Scanner(System.in);
        String yOrNo = newRound.nextLine();
        yOrNo = yOrNo.toLowerCase();

        switch (yOrNo){
            case "y":
                game();
                break;
            case "n":
                intro();
                break;
            default:
                System.out.println("");
                System.out.println("It's just one letter, dummy, try again.");
                playAgain();
        }

    }

//History
    public static void history(){

        System.out.println("");
        System.out.println("Total player wins this session: " + totalwins.size());
        System.out.println("Total player losses this session: " + totallosses.size());
        System.out.println("Total ties this session: " + totalties.size());

        historyExtended();
    }

// History Extended
    public static void historyExtended(){

        System.out.println("");
        System.out.println("-- Type DETAIL to see all previous games in detail --");
        System.out.println("-- Type MENU to go back to the main menu --");
        System.out.println("-- Type HISTORY to see the total wins, losses, and ties of this session --");
        System.out.println("");

        Scanner historyInput = new Scanner(System.in);
        String historyChoice = historyInput.nextLine();
        historyChoice = historyChoice.toLowerCase();
        System.out.println("");

        switch (historyChoice){
            case "menu":
                intro();
                break;
            case "detail":
                totalHistory();
                historyExtended();
                break;
            case "history":
                history();
                break;
            default:
                System.out.println("\"After looking at all those losses, it isn't surprising you failed in this menu. Try again.\"");
                historyExtended();
        }
    }

// Read History from txt file
    public static void totalHistory(){

        try {
            File file = new File("/Users/joshuagoldberg/github/week-1/Project-0---Rock-Paper-Scissors/src/savedHistory.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

// Save History to txt file
    public static void saveHistory(String record){

        try {

            String content = record;

            File saveHistory = new File("/Users/joshuagoldberg/github/week-1/Project-0---Rock-Paper-Scissors/src/savedHistory.txt");

            if (!saveHistory.exists()) {
                saveHistory.createNewFile();
            }

            FileWriter writeHistory = new FileWriter(saveHistory.getAbsoluteFile(), true);
            BufferedWriter bufferHistory = new BufferedWriter(writeHistory);
            bufferHistory.write(content);
            bufferHistory.newLine();
            bufferHistory.close();


            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

// Current Time
    public static String currentTime(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(date) + ", " +  sdf.format(cal.getTime());
    }

// Quit
    public static void quit() {

        System.exit(0);

    }
}