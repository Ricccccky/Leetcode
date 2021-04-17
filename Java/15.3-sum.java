import java.util.*;

public class Main {
    public int[] solution(int[][][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0][0] += grid[i - 1][0][0];
            grid[i][0][1] += grid[i - 1][0][1];
        }
        for (int i = 1; i < col; i++) {
            grid[0][i][0] += grid[0][i - 1][0];
            grid[0][i][1] += grid[0][i - 1][1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int cost_1 = grid[i - 1][j][0];
                int benefit_1 = grid[i - 1][j][1];
                int cost_2 = grid[i][j - 1][0];
                int benefit_2 = grid[i][j - 1][1];
                
                if (cost_1 == cost_2) {
                    if (benefit_1 > benefit_2) {
                        grid[i][j][0] += grid[i - 1][j][0];
                        grid[i][j][1] += grid[i - 1][j][1];
                    } else {
                        grid[i][j][0] += grid[i][j - 1][0];
                        grid[i][j][1] += grid[i][j - 1][1];
                    }
                } else {
                    if (cost_1 < cost_2) {
                        grid[i][j][0] += grid[i - 1][j][0];
                        grid[i][j][1] += grid[i - 1][j][1];
                    } else {
                        grid[i][j][0] += grid[i][j - 1][0];
                        grid[i][j][1] += grid[i][j - 1][1];
                    }
                }
            }
        }
        
        return grid[row - 1][col - 1];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        sc.nextLine();
        int[][][] grid = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            s = sc.nextLine().split(" ");
            sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j][0] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            s = sc.nextLine().split(" ");
            if (i < n - 1) {
                sc.nextLine();
            }
            for (int j = 0; j < m; j++) {
                grid[i][j][1] = Integer.parseInt(s[j]);
            }
        }
        
        Main main = new Main();
        int[] res = main.solution(grid);
        System.out.println(res[0] + " " + res[1]);
    }
}