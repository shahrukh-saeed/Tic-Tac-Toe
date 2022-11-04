import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        Scanner read = new Scanner(System.in);
        String XO = "";
        String loc = "";
        int turn = 0;
        String mode = "";

        System.out.println("Welcome to Tic-Tac-Toe! To quit at anytime, enter Q.\n");

        System.out.print("Would you like to play against a friend or a bot? ");
        mode = read.nextLine();

        while (true) {
            boolean success = false;            

            System.out.println();
            board.printBoard();

            if (board.checkMatch() == true) {
                System.out.println("\n" + XO + " won!");
                break;
            } else if (turn == 9) {
                System.out.println("\nIt's a tie!");
                break;
            }

            if (turn % 2 == 0) {
                System.out.println("It's X's turn!");
                XO = "X";       

            } else {
                System.out.println("It's O's turn!");
                XO = "O";
            }

            while (success == false) {

                if (mode.equalsIgnoreCase("bot") && XO.equalsIgnoreCase("O")) {
                    loc = String.valueOf(board.bot());
                } else {
                    System.out.print("Please choose a box [1-9]: ");
                    loc = read.nextLine();
    
                    if (loc.equalsIgnoreCase("Q")) {
                        System.out.println("\nThanks for playing!");
                        System.exit(0);
                    }
                }
    
                success = board.addXO(XO, Integer.parseInt(loc)-1);

                if(success == false && XO.equalsIgnoreCase("X")) {
                    System.out.println("\nThat box is already full! Please try again. ");
                }
            }
            turn++;
        }
        
    }

}
