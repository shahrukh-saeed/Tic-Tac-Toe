import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Board {
    private String[][] board;

    private Map<Integer, String> locs;

    public Board() {
        this.board = new String[3][3];
        this.locs = new TreeMap<>();

        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "     ";
                locs.put(count, String.valueOf(i) + "," + String.valueOf(j));
                count++;
            }
        }
    }

    public boolean addXO(String XO, int loc) {
        String[] c = locs.get(loc).split(",");
        int i = Integer.parseInt(c[0]);
        int j = Integer.parseInt(c[1]);

        if (board[i][j].equalsIgnoreCase("  X  ") || board[i][j].equalsIgnoreCase("  O  ")) {
            return false;
        } else {
            board[i][j] = "  " + XO + "  ";
            return true;
        }
    }

    public boolean checkMatch() {
        String[] matchX = { "  X  ", "  X  ", "  X  " };
        String[] matchO = { "  O  ", "  O  ", "  O  " };

        String[] col0 = getCol(0);
        String[] col1 = getCol(1);
        String[] col2 = getCol(2);

        String[] diag0 = getDiag(0);
        String[] diag1 = getDiag(1);

        if (Arrays.equals(board[0], matchX) || Arrays.equals(board[1], matchX) || Arrays.equals(board[2], matchX) ||
                Arrays.equals(board[0], matchO) || Arrays.equals(board[1], matchO) || Arrays.equals(board[2], matchO)) {
            return true;
        }

        if (Arrays.equals(col0, matchX) || Arrays.equals(col1, matchX) || Arrays.equals(col2, matchX) ||
                Arrays.equals(col0, matchO) || Arrays.equals(col1, matchO) || Arrays.equals(col2, matchO)) {
            return true;
        }

        if (Arrays.equals(diag0, matchX) || Arrays.equals(diag1, matchX) ||
                Arrays.equals(diag0, matchO) || Arrays.equals(diag1, matchO)) {
            return true;
        }

        return false;
    }

    public int bot() {
        String[] matchX = { "  X  ", "  X  ", "     " };
        String[] matchO = { "  O  ", "  O  ", "     " };
        String[] matchX1 = { "     ", "  X  ", "  X  " };
        String[] matchO1 = { "     ", "  O  ", "  O  " };
        String[] matchX2 = { "  X  ", "     ", "  X  " };
        String[] matchO2 = { "  O  ", "     ", "  O  " };

        String[] col0 = getCol(0);
        String[] col1 = getCol(1);
        String[] col2 = getCol(2);

        String[] diag0 = getDiag(0);
        String[] diag1 = getDiag(1);

        //rows
        if (Arrays.equals(board[0], matchO2))
            return 2;
        else if (Arrays.equals(board[1], matchO2))
            return 5;
        else if (Arrays.equals(board[2], matchO2))
            return 8;
        else if (Arrays.equals(board[0], matchO1))
            return 1;
        else if (Arrays.equals(board[1], matchO1))
            return 4;
        else if (Arrays.equals(board[2], matchO1))
            return 7;
        else if (Arrays.equals(board[0], matchO))
            return 3;
        else if (Arrays.equals(board[1], matchO))
            return 6;
        else if (Arrays.equals(board[2], matchO))
            return 9;
        else if (Arrays.equals(board[0], matchX2))
            return 2;
        else if (Arrays.equals(board[1], matchX2))
            return 5;
        else if (Arrays.equals(board[2], matchX2))
            return 8;
        else if (Arrays.equals(board[0], matchX1))
            return 1;
        else if (Arrays.equals(board[1], matchX1))
            return 4;
        else if (Arrays.equals(board[2], matchX1))
            return 7;
        else if (Arrays.equals(board[0], matchX))
            return 3;
        else if (Arrays.equals(board[1], matchX))
            return 6;
        else if (Arrays.equals(board[2], matchX))
            return 9;

        // columns
        if (Arrays.equals(col0, matchO2))
            return 4;
        else if (Arrays.equals(col1, matchO2))
            return 5;
        else if (Arrays.equals(col2, matchO2))
            return 6;
        else if (Arrays.equals(col0, matchO1))
            return 1;
        else if (Arrays.equals(col1, matchO1))
            return 2;
        else if (Arrays.equals(col2, matchO1))
            return 3;
        else if (Arrays.equals(col0, matchO))
            return 7;
        else if (Arrays.equals(col1, matchO))
            return 8;
        else if (Arrays.equals(col2, matchO))
            return 9;
        else if (Arrays.equals(col0, matchX2))
            return 4;
        else if (Arrays.equals(col1, matchX2))
            return 5;
        else if (Arrays.equals(col2, matchX2))
            return 6;
        else if (Arrays.equals(col0, matchX1))
            return 1;
        else if (Arrays.equals(col1, matchX1))
            return 2;
        else if (Arrays.equals(col2, matchX1))
            return 3;
        else if (Arrays.equals(col0, matchX))
            return 7;
        else if (Arrays.equals(col1, matchX))
            return 8;
        else if (Arrays.equals(col2, matchX))
            return 9;

        // diagonals
        if (Arrays.equals(diag0, matchO2))
            return 5;
        else if (Arrays.equals(diag1, matchO2))
            return 5;
        else if (Arrays.equals(diag0, matchO1))
            return 1;
        else if (Arrays.equals(diag1, matchO1))
            return 3;
        else if (Arrays.equals(diag0, matchO))
            return 9;
        else if (Arrays.equals(diag1, matchO))
            return 7;
        else if (Arrays.equals(diag0, matchX2))
            return 5;
        else if (Arrays.equals(diag1, matchX2))
            return 5;
        else if (Arrays.equals(diag0, matchX1))
            return 1;
        else if (Arrays.equals(diag1, matchX1))
            return 3;
        else if (Arrays.equals(diag0, matchX))
            return 9;
        else if (Arrays.equals(diag1, matchX))
            return 7;

        return (int) Math.floor(Math.random() * (9 - 1 + 1) + 1);
    }

    public void printBoard() {
        System.out.println("-------------------");

        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("-------------------");

        }
    }

    public String[] getCol(int col) {
        String[] col0 = { "", "", "" };
        String[] col1 = { "", "", "" };
        String[] col2 = { "", "", "" };

        int count = 0;
        int count1 = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (count == 0 || count == 3 || count == 6) {
                    col0[count1] = board[i][j];
                } else if (count == 1 || count == 4 || count == 7) {
                    col1[count1] = board[i][j];
                } else if (count == 2 || count == 5 || count == 8) {
                    col2[count1] = board[i][j];
                }
                count++;
            }
            count1++;
        }

        if (col == 0) {
            return col0;
        } else if (col == 1) {
            return col1;
        } else if (col == 2) {
            return col2;
        }

        return null;
    }

    public String[] getDiag(int diag) {
        String[] diag0 = { "", "", "" };
        String[] diag1 = { "", "", "" };

        int count = 0;
        int count1 = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (count == 0 || count == 4 || count == 8) {
                    diag0[count1] = board[i][j];
                } else if (count == 2 || count == 4 || count == 6) {
                    diag1[count1] = board[i][j];

                }
                count++;
            }
            count1++;
        }

        diag1[1] = diag0[1];

        if (diag == 0) {
            return diag0;
        } else if (diag == 1) {
            return diag1;
        }

        return null;
    }
}
