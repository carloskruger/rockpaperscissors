import java.lang.reflect.Array;

public class Computer {
    private  String [] listOfMoves = {"rock", "paper", "scissors"};

    public Computer(){};

    public String calculateMove() {
            int max = 2;
            int min = 0;
            int range = max - min + 1;
            int choice = (int)( Math.random() * range ) + min;
            return this.listOfMoves[choice];
        }

}
