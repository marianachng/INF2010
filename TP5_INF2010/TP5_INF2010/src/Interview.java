import java.util.*;

public class Interview {
    private static final int[][] DIRECTIONS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int minCost(Cell[][] grid) {
        /* Ne pas modifier ce code */
        int m = grid.length, n = grid[0].length;

        Cell[][] costs = new Cell[m][n];
        for (Cell[] c : costs){
            for(int i = 0; i < c.length; i++){
                c[i] = new Cell(0,0,Integer.MAX_VALUE);
            }
        }
        costs[0][0].cost = 0;

        PriorityQueue<Cell> heap = new PriorityQueue<>();
        heap.offer(new Cell(0,0,0));
        /* Ne pas modifier ce code */

        while (!heap.isEmpty()) {
            Cell curr = heap.poll();
            int x = curr.xPos,  y = curr.yPos, cost = curr.cost;

            if (x == n - 1 && y == m - 1 /*TODO Condition si on arrive à la fin de la matrice */)
                return cost;


            for (int i = 0; i < 4; i++) {
                int[] dir = DIRECTIONS[i];
                int newX = x + dir[1], newY = y + dir[0];
                if (!((newX >= 0 && newX < n) && (newY >= 0 && newY < m))/*TODO Condition qui assure qu'on est toujours dans les bornes de la matrice */) continue;

                int newCost = costs[x][y].cost/*TODO Calculer le nouveau cout selon le deplacement*/;
                if(i != grid[x][y].cost) newCost += 1;
                if (costs[newY][newX].cost > newCost) {
                    /*TODO Mettre le nouveau cout au bonne emplacement dans la matrice & l'ajouter au heap.*/
                    costs[newX][newY].cost = newCost;
                }
            }
        }

        return -1;
    }
}
