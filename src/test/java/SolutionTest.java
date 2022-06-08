import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static constants.TestConstants.CREATURE;
import static constants.TestConstants.GRID_STR;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({"Human, 10", "Swamper, 15", "Woodman, 12"})
    void getResult(String creature, int result) {
        int minCost = Solution.getResult(GRID_STR, creature);
        assertEquals(result, minCost);
    }
}