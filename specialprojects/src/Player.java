import java.util.ArrayList;

public class Player {
    private String name;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private String result;
    private ArrayList<String> history = new ArrayList<>();
    Player(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void incrementGamesWon() {
        this.gamesWon++;
    }

    public void incrementGamesLost() {
        this.gamesLost++;
    }


    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void addHistory(String result) {
        this.history.add(result);
    }

    public void showHistory(){
        if (history.size() > 0){
               this.history.forEach( result -> System.out.println(result  + "\n" ));
    }
        else System.out.println("You have played. No history to show");
    }
}
