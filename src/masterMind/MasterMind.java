package masterMind;

public class MasterMind
{
    public static void main(String[] args)
    {
        int numberOfRounds = 10;
        Game game = new Game(numberOfRounds);
        game.start();

    }
}
