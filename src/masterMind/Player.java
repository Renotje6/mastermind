package masterMind;

import java.util.Scanner;

public class Player
{
    private static Scanner scanner = new Scanner(System.in);

    // Handles the user input
    public String[] getInput()
    {
        System.out.println("Enter your guess: ");
        String[] input = scanner.nextLine().split("[ ,]");
        boolean isInputCorrect = false;

        while (!isInputCorrect)
        {
            for (int i = 0; i < input.length; i++)
            {
                if (input.length != 4 || !Colours.enumContainsValue(input[i]))
                {
                    System.out.println("Invalid input");
                    input = scanner.nextLine().split("[ ,]");
                    break;
                } else
                {
                    isInputCorrect = true;
                }
            }
        }
        return input;
    }

    public void closeScanner() {
        Player.scanner.close();
    }
}
