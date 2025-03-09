import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];

        int metade = (3 * 3) / 2; // Define a metade da matriz (4 elementos)
        int count = 0;

        // Preenchendo a matriz
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (count < metade) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 2;
                }
                count++;
            }
        }
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.solution(matriz, 0, 0, 3)));
    }
}