
import utils.Cell;

import java.util.*;

import static utils.Utils.isInGrid;
import static utils.Utils.transformStringToGrid;


public class Solution {

    private static final int[] ROW_DIFFS = { -1, 0, 1, 0 };
    private static final int[] COLUMN_DIFFS = { 0, 1, 0, -1 };

    public static int getResult(String gridStr, String creature) {
        return getShortestPath(transformStringToGrid(gridStr, creature));
    }

    private static int getShortestPath(int[][] grid) {
        int[][] weights = new int[grid.length][grid[0].length];
        for (int[] weight : weights) {
            Arrays.fill(weight, Integer.MAX_VALUE);
        }
        weights[0][0] = 0;
        Queue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(Cell::getWeight));
        queue.add(new Cell(0, 0, weights[0][0]));
        while(!queue.isEmpty()) {
            Cell current = queue.poll();
            int currRow = current.getRow();
            int currColumn = current.getColumn();
            for(int i = 0; i < 4; ++i) {
                int nextRow = currRow + ROW_DIFFS[i];
                int nextColumn = currColumn + COLUMN_DIFFS[i];
                if(isInGrid(grid, nextRow, nextColumn) &&
                        weights[nextRow][nextColumn] > weights[currRow][currColumn] + grid[nextRow][nextColumn]) {
                    if(weights[nextRow][nextColumn] != Integer.MAX_VALUE) {
                        Cell nextCellBefore = new Cell(nextRow, nextColumn, weights[nextRow][nextColumn]);
                        queue.remove(nextCellBefore);
                    }
                    weights[nextRow][nextColumn] = weights[currRow][currColumn] + grid[nextRow][nextColumn];
                    queue.add(new Cell(nextRow, nextColumn, weights[nextRow][nextColumn]));
                }
            }
        }
        return weights[weights.length - 1][weights[0].length - 1];
    }

}
