package utils;

import java.util.Arrays;
import java.util.Map;

public class Utils {

    private static final Map<String, Map<Character, Integer>> CREATURES_MAP = FileUtils.getCreaturesMap();

    public static int[][] transformStringToGrid(String strForTransform, String creature) {
        Map<Character, Integer> cellTypeToCost = CREATURES_MAP.get(creature);
        int[][] grid = new int[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; ++j) {
                char cell = strForTransform.charAt(i * 4 + j);
                grid[i][j] = cellTypeToCost.get(cell);
            }
        }
        return grid;
    }

    public static boolean isInGrid(int[][] grid, int row, int column) {
        return (row >= 0 && row < grid.length) && (column >= 0 && column < grid[0].length);
    }

}
