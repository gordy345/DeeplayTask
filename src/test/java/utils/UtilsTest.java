package utils;

import constants.TestConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constants.TestConstants.CREATURE;
import static constants.TestConstants.GRID;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void transformStringToGrid() {
        int[][] grid = Utils.transformStringToGrid(TestConstants.GRID_STR, CREATURE);
        assertTrue(Arrays.deepEquals(grid, GRID));
    }

    @ParameterizedTest
    @CsvSource({"-1, 0", "0, -1", "4, 0", "0, 4"})
    void isInGridFalseTest(int row, int column) {
        assertFalse(Utils.isInGrid(GRID, row, column));
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "0, 3", "3, 0", "3, 3", "2, 2"})
    void isInGridTrueTest(int row, int column) {
        assertTrue(Utils.isInGrid(GRID, row, column));
    }
}