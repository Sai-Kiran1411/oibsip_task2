import java.util.*;
public class Number{
    static ArrayList<Integer> sb = new ArrayList<Integer>();
    public static void main(String[] args) {
        Number methodChange = new Number();
        methodChange.menu(sb);
    }
    public void menu(ArrayList<Integer> sb) {
        Number methodChange = new Number();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number game\n");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
        System.out.println("--------------------");
        try {
            System.out.print("\nEnter Your Choice: ");
            int menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"Input the range of the numbers: ");
                    int numberRange = input.nextInt();
                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(sb);
        }
    }
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        sb.add(guess);
        System.out.println(" ");

        menu(sb);
    }
    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out of all tries is: " +"\n");
        Collections.sort(sb);
        for (Integer scores : sb) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(sb);
    }
}
