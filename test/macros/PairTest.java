package macros;

import base.LambdaExpression;
import org.junit.Test;

import static base.LambdaExpression.variable;
import static macros.Pair.*;

public class PairTest {

    @Test
    public void testPairFirst() {
        LambdaExpression pair = pair(variable("a"), variable("b"));
        LambdaExpression first = first(pair);

        assert first.reduce().equals(variable("a"));
    }

    @Test
    public void testPairSecond() {
        LambdaExpression pair = pair(variable("a"), variable("b"));
        LambdaExpression second = second(pair);

        assert second.reduce().equals(variable("b"));
    }

    @Test
    public void testPairSwap() {
        LambdaExpression pair = pair(variable("a"), variable("b"));
        LambdaExpression swapped = swap(pair);

        assert swapped.reduce().equals(pair(variable("b"), variable("a")));
    }
}
