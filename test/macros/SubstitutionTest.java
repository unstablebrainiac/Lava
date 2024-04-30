package macros;

import base.LambdaExpression;
import org.junit.Test;

import static base.LambdaExpression.*;

public class SubstitutionTest {
    @Test
    public void testSubstitution() {
        // (λ x . x y) (x z)
        // (x z) y
        LambdaExpression expression = apply(lambda(variable("x"), apply(variable("x"), variable("y"))), apply(variable("x"), variable("z")));
        assert expression.reduce().equals(apply(apply(variable("x"), variable("z")), variable("y")));
    }

    @Test
    public void testSubstitution2() {
        // (λ x . (λ x . x y)) (x z)
        // (λ x . x y)
        LambdaExpression expression = apply(lambda(variable("x"), lambda(variable("x"), apply(variable("x"), variable("y")))), apply(variable("x"), variable("z")));
        assert expression.reduce().equals(lambda(variable("x"), apply(variable("x"), variable("y"))));
    }
}
