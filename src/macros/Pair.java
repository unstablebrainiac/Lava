package macros;

import base.LambdaExpression;

import static base.LambdaExpression.*;
import static macros.Booleans.FALSE;
import static macros.Booleans.TRUE;

public class Pair {

    // pair := λ x . λ y . λ f . f x y
    public static final LambdaExpression PAIR = lambda(
        variable("x"),
        lambda(
            variable("y"),
            lambda(
                variable("f"),
                apply(
                    apply(variable("f"), variable("x")),
                    variable("y")
                )
            )
        )
    );

    public static LambdaExpression pair(LambdaExpression x, LambdaExpression y) {
        return apply(apply(PAIR, x), y).reduce();
    }

    // first := λ p . p true
    public static final LambdaExpression FIRST = lambda(
        variable("p"),
        apply(
            variable("p"),
            TRUE
        )
    );

    public static LambdaExpression first(LambdaExpression p) {
        return apply(FIRST, p);
    }

    // second := λ p . p false
    public static final LambdaExpression SECOND = lambda(
        variable("p"),
        apply(
            variable("p"),
            FALSE
        )
    );

    public static LambdaExpression second(LambdaExpression p) {
        return apply(SECOND, p);
    }

    // swap := λ p . pair (second p) (first p)
    public static final LambdaExpression SWAP = lambda(
        variable("p"),
        apply(
            apply(
                    PAIR,
                    apply(
                            SECOND,
                            variable("p")
                    )
            ),
            apply(
                    FIRST,
                    variable("p")
            )
        )
    );

    public static LambdaExpression swap(LambdaExpression p) {
        return apply(SWAP, p);
    }
}
