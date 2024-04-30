package macros;

import base.LambdaExpression;
import org.junit.Test;

import static base.LambdaExpression.variable;
import static macros.Booleans.*;

public class BooleansTest {

    @Test
    public void testIfTrue() {
        LambdaExpression expression = if_(TRUE, variable("a"), variable("b"));
        assert expression.reduce().equals(variable("a"));
    }

    @Test
    public void testIfTrue2() {
        LambdaExpression expression = if_(TRUE, TRUE, FALSE);
        assert expression.reduce().equals(TRUE);
    }

    @Test
    public void testIfFalse() {
        LambdaExpression expression = if_(FALSE, variable("a"), variable("b"));
        assert expression.reduce().equals(variable("b"));
    }

    @Test
    public void testNotTrue() {
        LambdaExpression expression = not(TRUE);
        assert expression.reduce().equals(FALSE);
    }

    @Test
    public void testNotFalse() {
        LambdaExpression expression = not(FALSE);
        assert expression.reduce().equals(TRUE);
    }

    @Test
    public void testAndTrueTrue() {
        LambdaExpression expression = and(TRUE, TRUE);
        assert expression.reduce().equals(TRUE);
    }

    @Test
    public void testAndTrueFalse() {
        LambdaExpression expression = and(TRUE, FALSE);
        assert expression.reduce().equals(FALSE);
    }

    @Test
    public void testAndFalseTrue() {
        LambdaExpression expression = and(FALSE, TRUE);
        assert expression.reduce().equals(FALSE);
    }

    @Test
    public void testAndFalseFalse() {
        LambdaExpression expression = and(FALSE, FALSE);
        assert expression.reduce().equals(FALSE);
    }

    @Test
    public void testOrTrueTrue() {
        LambdaExpression expression = or(TRUE, TRUE);
        assert expression.reduce().equals(TRUE);
    }

    @Test
    public void testOrTrueFalse() {
        LambdaExpression expression = or(TRUE, FALSE);
        assert expression.reduce().equals(TRUE);
    }

    @Test
    public void testOrFalseTrue() {
        LambdaExpression expression = or(FALSE, TRUE);
        assert expression.reduce().equals(TRUE);
    }

    @Test
    public void testOrFalseFalse() {
        LambdaExpression expression = or(FALSE, FALSE);
        assert expression.reduce().equals(FALSE);
    }
}
