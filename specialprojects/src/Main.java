import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void handlePlayChoice(Player player, Computer computer){
        String result = new String();
        System.out.println("Type 'rock', 'paper' or 'scissors' to play");
        Scanner input = new Scanner(System.in);
        String userEntry = input.next();
        String userMove = userEntry.toLowerCase();
        String computerMove = computer.calculateMove();
        System.out.println("Computer picks: " + computerMove);
        System.out.println(player.getName() + " picks: " + userMove);
        switch(userMove){
            case "rock":
                if (computerMove.equals("rock")){
                    result = player.getName()+ " entered rock. Computer entered rock. It is a tie";
                    System.out.println(result);
                    player.addHistory(result);
                }
                else if (computerMove.equals("paper")){
                    result = player.getName()+ " entered rock. Computer entered paper. Computer wins";
                    System.out.println(result);
                    player.addHistory(result);
                    player.incrementGamesLost();
                }
                 else if (computerMove.equals("scissors")){
                result = player.getName()+ " entered rock. Computer entered Scissors. "+ player.getName()+ " wins";
                    System.out.println(result);
                player.addHistory(result);
                player.incrementGamesWon();
            };
                break;
            case "paper":
                if (computerMove.equals("rock")){
                    result = player.getName()+ " entered paper. Computer entered rock. "+ player.getName()+ " wins";
                    System.out.println(result);
                    player.addHistory(result);
                    player.incrementGamesWon();
                }
                else if (computerMove.equals("paper")){
                    result = player.getName()+ " entered paper. Computer entered paper. It is a tie";
                    System.out.println(result);
                    player.addHistory(result);
                }
                 else if (computerMove.equals("scissors")){
                result = player.getName()+ " entered paper. Computer entered Scissors. Computer wins";
                    System.out.println(result);
                    player.addHistory(result);
                    player.incrementGamesLost();
                 };
                break;
            case "scissors":
                if (computerMove.equals("rock")){
                    result = player.getName()+ " entered scissors. Computer entered rock. Computer wins" ;
                    System.out.println(result);
                    player.addHistory(result);
                }
                else if (computerMove.equals("paper")){
                    result = player.getName()+ " entered scissors. Computer entered paper. "+ player.getName()+ " wins";
                    System.out.println(result);
                    player.addHistory(result);
                    player.incrementGamesWon();
                }
                 else if (computerMove.equals("scissors")){
                result = player.getName()+ " entered scissors. Computer entered Scissors. It is a tie";
                    System.out.println(result);
                    player.addHistory(result);
            };
                break;
            default:
                System.out.println("Something is wrong. What you entered is: " + userMove);
                break;
        }

    }

    public static void playAgainstComputer(Player player, Computer computer){
        boolean stopTheFunction = false;
        while(stopTheFunction == false){
            System.out.println("MAIN MENU");
            System.out.println("1. Type 'play' to play");
            System.out.println("2. Type 'history' to view your game history");
            System.out.println("3. Type 'quit' to stop playing");
            Scanner input = new Scanner(System.in);

            String userEntry = input.next();

            String userEntryLC = userEntry.toLowerCase();


            switch(userEntryLC) {
                case "play":
                    handlePlayChoice(player, computer);
                    break;
                case "history":
                    System.out.println(player.getHistory());
                    break;
                case "quit":
                    stopTheFunction = true;
                    break;
                default:
                    System.out.println("Incorrect choice. You entered " + userEntry);
                    break;

            }

        }

    }

    public static void playAgainstAnotherPlayer(Player player1,Player player2, Computer computer){
        for (int i = 0; i < 3; i++){
            System.out.println("Round " + (i + 1 ));
            System.out.println(player1.getName() + " plays");
            handlePlayChoice(player1, computer);

            System.out.println(player2.getName() + " plays");
            handlePlayChoice(player2, computer);
            System.out.println("===========================================");
        }
        System.out.println(player1.getName() + " won " + player1.getGamesWon() + " games!");
        System.out.println(player2.getName() + " won " + player2.getGamesWon() + " games!");

        if (player1.getGamesWon() == player2.getGamesWon()) {
            System.out.println("It is a tie!!!!");
        };
        if (player1.getGamesWon() > player2.getGamesWon()) {
            System.out.println(player1.getName() + " is the winner!!!!");
        };
        if (player2.getGamesWon() > player1.getGamesWon()) {
            System.out.println(player2.getName() + " is the winner!!!!");
        };


    };


    public static void main(String[] args) {
        String result;
        ArrayList<String> history = new ArrayList<>();
        boolean validEntry = false;
        Player player1 = new Player();
        Player player2 = new Player();
        Computer computer = new Computer();

        System.out.println("Welcome to Rock, Paper and Scissors!");
        System.out.println("Choose your Option ");
        System.out.println("1.    2 Players (Enter 1)");
        System.out.println("2.    vs. Computer (Enter 2)");
        System.out.println("3.    Exit the game  (Enter 3)");

        Scanner input = new Scanner(System.in);
        String userEntry = input.next();

        if (!userEntry.equals("1") && !userEntry.equals("2") && !userEntry.equals("3")) {
                System.out.println("You must enter either 1 or 2 ot 3");
        }


        switch (userEntry){
            case "1":
                System.out.println("You will play with another player. You entered: " + userEntry);
                System.out.println("What is your name?");
                String player1Name = input.next();
                player1.setName(player1Name);
                System.out.println("What is the other player's name?");
                String player2Name = input.next();
                player2.setName(player2Name);
                System.out.println("Hello "+ player1.getName() + " and " + player2.getName() + "!!! Just follow the instructions on the screen");
                System.out.println("the computer will play 3 times take turns playing against you. Whoever, wins more rounds is the winner!!!");
                playAgainstAnotherPlayer(player1, player2, computer);
                break;
            case "2":
                System.out.println("The entry was : " +  userEntry + "  You are playing against the computer");
                System.out.println("What is your name?");
                player1Name = input.next();
                player1.setName(player1Name);
                System.out.println("Hi "+ player1.getName() + "!!! Just follow the instructions on the screen");
                playAgainstComputer(player1, computer);
                break;
            case "3":
                System.out.println("The entry was : " + userEntry + "   Now we will exit");
                break;
        }
        }
    }


