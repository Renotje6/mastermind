package masterMind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game
{
    private int numberOfRounds;
    private String[] code;
    private Player player;

    public Game(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        this.code = this.generateCode();
        this.player = new Player();
    }

    // Generates the code
    private String[] generateCode()
    {
        String[] code = new String[4];
        Random rdm = new Random();

        for (int i = 0; i < code.length; i++)
        {
            code[i] = String.valueOf(Colours.ColoursEnum.values()[rdm.nextInt(6)]);
        }
        System.out.println(Arrays.toString(code));
        return code;
    }

    private int[] checkGuess(String[] guess)
    {
        int blackPins = 0;
        int whitePins = 0;
        ArrayList<String> copyOfCode = new ArrayList<>(Arrays.asList(this.code));

        // Checks black pins
        for (int i = 0; i < guess.length; i++)
        {
            if (guess[i].equals(copyOfCode.get(i)))
            {
                copyOfCode.set(i, "");
                blackPins++;
            }
        }

        while (copyOfCode.remove("")) ;

        // Checks white pins
        for (String s : guess)
        {
            if (copyOfCode.contains(s))
            {
                copyOfCode.remove(s);
                whitePins++;
            }
        }

        return new int[]
                {blackPins, whitePins};
    }

    public void start() {
        boolean guessedCorrectly = false;
        int turn = 1;

        System.out.println("Example guess: red green red yellow");

        while (turn <= this.numberOfRounds && !guessedCorrectly)
        {
            int[] pins;
            int blackPins, whitePins;
            String[] guess;

            System.out.println("\nTurn " + turn);

            guess = this.player.getInput();
            pins = this.checkGuess(guess);

            blackPins = pins[0];
            whitePins = pins[1];

            System.out.println("You guessed: " + Arrays.toString(guess) + "\nYou got " + blackPins + " black pins and "
                    + whitePins + " white pins.");

            if (blackPins == 4)
            {
                guessedCorrectly = true;
            } else
            {
                turn++;
            }

        }

        if (guessedCorrectly)
        {
            System.out.println("Congratulations! You cracked the code!");
        } else
        {
            System.out.println("\n" + this.numberOfRounds + " rounds have passed and you failed to crack the code... try again!");
            System.out.println("The code was: " + Arrays.toString(this.code).replace(",", "")
                    .replace("[", "")
                    .replace("]", ""));
        }
        this.player.closeScanner();
    }
}
