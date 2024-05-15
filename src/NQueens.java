import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 1;
        List<List<StringBuilder>> ways = getWaysForNQueens(n);
        System.out.println("ways = " + ways);
    }

    public static List<List<StringBuilder>> getWaysForNQueens(int n) {
        List<StringBuilder> board = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            temp.setCharAt(i, '.');
        }
        for (int i = 0; i < n; i++) {
            board.add(temp);
        }
        List<List<StringBuilder>> ways = new ArrayList<>();
        compute(0, board, ways, n);
        return ways;
    }

    public static void compute(int colIndex, List<StringBuilder> board, List<List<StringBuilder>> ways, int n) {
        if (colIndex == n) {
            ways.add(board);
            return;
        }
        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            if (canFill(colIndex, rowIndex, board, n)) {
                board.get(rowIndex).setCharAt(colIndex, 'Q');
                compute(colIndex + 1, board, ways, n);
                board.get(rowIndex).setCharAt(colIndex, '.');
            }
        }
    }

    private static boolean canFill(int colIndex, int rowIndex, List<StringBuilder> board, int n) {

        // check upper diagonal has queen
        int col = colIndex;
        int row = rowIndex;
        while (row >= 0 && col >= 0) {
            if (board.get(rowIndex).charAt(colIndex) == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        //check if lower diagonal has queen
        col = colIndex;
        row = rowIndex;
        while (col >= 0 && row < n) {
            if (board.get(rowIndex).charAt(colIndex) == 'Q') {
                return false;
            }
            row++;
            col--;
        }


        // check if same row has queen to left
        row = rowIndex;
        col = colIndex;
        while (col >= 0) {
            if (board.get(rowIndex).charAt(colIndex) == 'Q') {
                return false;
            }
            col--;
        }

        return true;
    }
}
