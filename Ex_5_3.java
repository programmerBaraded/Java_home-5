import java.util.HashMap;
import java.util.Map;

// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. 
// И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000


public class Ex_5_3 {
    public static void main(String[] args) {
        Map<Integer, Integer> board = new HashMap<>();
        placeQueens(board, 0);
        printBoard(board);
    }

    public static void printBoard(Map<Integer, Integer> board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int pos = i * 8 + j;
                if (board.containsKey(pos)) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }

    public static boolean canPlace(Map<Integer, Integer> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board.containsKey(i * 8 + col)) {               
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.containsKey(i * 8 + j)) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < 8; i--, j++) {
            if (board.containsKey(i * 8 + j)) {
                return false;
            }
        }
        return true;
    }

    public static boolean placeQueens(Map<Integer, Integer> board, int row) {
        if (row == 8) {
            return true;
        }
        for (int i = 0; i < 8; i++) {
            if (canPlace(board, row, i)) {
                board.put(row * 8 + i, 1);
                if (placeQueens(board, row + 1)) {
                    return true;
                }
                board.remove(row * 8 + i);
            }
        }
        return false;
    }
}
