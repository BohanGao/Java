import java.util.Arrays;
import java.util.List;

public class Roster {
    private List<String> players;

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public void printPlayers(){
        System.out.println(Arrays.asList(players));
    }
}
