package macros;

import base.LambdaExpression;

import static base.LambdaExpression.*;

public class Nat {
    // O := λf.λx.x
    public static final LambdaExpression O = lambda(
            variable("f"),
            lambda(
                    variable("x"),
                    variable("x")
            )
    );

    // S := λn.λf.λx.f (n f x)
    public static final LambdaExpression S = lambda(
            variable("n"),
            lambda(
                    variable("f"),
                    lambda(
                            variable("x"),
                            apply(
                                    variable("f"),
                                    apply(
                                            apply(
                                                    variable("n"),
                                                    variable("f")
                                            ),
                                            variable("x")
                                    )
                            )
                    )
            )
    );

    public static LambdaExpression S(LambdaExpression n) {
        return apply(S, n);
    }

    public static LambdaExpression ZERO = O;
    public static LambdaExpression ONE = S(ZERO).reduce();
    public static LambdaExpression TWO = S(ONE).reduce();
    public static LambdaExpression THREE = S(TWO).reduce();
    public static LambdaExpression FOUR = S(THREE).reduce();
    public static LambdaExpression FIVE = S(FOUR).reduce();
    public static LambdaExpression SIX = S(FIVE).reduce();
    public static LambdaExpression SEVEN = S(SIX).reduce();
    public static LambdaExpression EIGHT = S(SEVEN).reduce();
    public static LambdaExpression NINE = S(EIGHT).reduce();
    public static LambdaExpression TEN = S(NINE).reduce();

    // plus := λm.λn.λf.λx.m f (n f x)
    public static final LambdaExpression PLUS = lambda(
            variable("m"),
            lambda(
                    variable("n"),
                    lambda(
                            variable("f"),
                            lambda(
                                    variable("x"),
                                    apply(
                                            apply(
                                                    variable("m"),
                                                    variable("f")
                                            ),
                                            apply(
                                                    apply(
                                                            variable("n"),
                                                            variable("f")
                                                    ),
                                                    variable("x")
                                            )
                                    )
                            )
                    )
            )
    );

    public static LambdaExpression plus(LambdaExpression m, LambdaExpression n) {
        return apply(apply(PLUS, m), n);
    }

    // times := λm.λn.λf.m (n f)
    public static final LambdaExpression TIMES = lambda(
            variable("m"),
            lambda(
                    variable("n"),
                    lambda(
                            variable("f"),
                            apply(
                                    variable("m"),
                                    apply(
                                            variable("n"),
                                            variable("f")
                                    )
                            )
                    )
            )
    );

    public static LambdaExpression times(LambdaExpression m, LambdaExpression n) {
        return apply(apply(TIMES, m), n);
    }
}
