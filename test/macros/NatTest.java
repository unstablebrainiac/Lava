package macros;

import org.junit.Test;

import static macros.Nat.*;

public class NatTest {
    @Test
    public void testSuccessor() {
        // S(0) = 1
        assert S(Nat.ZERO).reduce().equals(ONE);
        // S(1) = 2
        assert S(ONE).reduce().equals(TWO);
        // S(2) = 3
        assert S(TWO).reduce().equals(THREE);
        // S(3) = 4
        assert S(THREE).reduce().equals(FOUR);
        // S(4) = 5
        assert S(FOUR).reduce().equals(FIVE);
        // S(5) = 6
        assert S(FIVE).reduce().equals(SIX);
        // S(6) = 7
        assert S(SIX).reduce().equals(SEVEN);
        // S(7) = 8
        assert S(SEVEN).reduce().equals(EIGHT);
        // S(8) = 9
        assert S(EIGHT).reduce().equals(NINE);
        // S(9) = 10
        assert S(NINE).reduce().equals(TEN);
    }

    @Test
    public void testPlus() {
        // 0 + 0 = 0
        assert plus(ZERO, ZERO).reduce().equals(ZERO);
        // 0 + 1 = 1
        assert plus(ZERO, ONE).reduce().equals(ONE);
        // 1 + 0 = 1
        assert plus(ONE, ZERO).reduce().equals(ONE);
        // 1 + 1 = 2
        assert plus(ONE, ONE).reduce().equals(TWO);
        // 2 + 3 = 5
        assert plus(TWO, THREE).reduce().equals(FIVE);
        // 3 + 2 = 5
        assert plus(THREE, TWO).reduce().equals(FIVE);
        // 4 + 6 = 10
        assert plus(FOUR, SIX).reduce().equals(TEN);
        // 5 + 5 = 10
        assert plus(FIVE, FIVE).reduce().equals(TEN);
    }

    @Test
    public void testTimes() {
        // 0 * 0 = 0
        assert times(ZERO, ZERO).reduce().equals(ZERO);
        // 0 * 1 = 0
        assert times(ZERO, ONE).reduce().equals(ZERO);
        // 1 * 0 = 0
        assert times(ONE, ZERO).reduce().equals(ZERO);
        // 1 * 1 = 1
        assert times(ONE, ONE).reduce().equals(ONE);
        // 2 * 3 = 6
        assert times(TWO, THREE).reduce().equals(SIX);
        // 3 * 2 = 6
        assert times(THREE, TWO).reduce().equals(SIX);
        // 3 * 3 = 9
        assert times(THREE, THREE).reduce().equals(NINE);
        // 2 * 5 = 10
        assert times(TWO, FIVE).reduce().equals(TEN);
    }
}
