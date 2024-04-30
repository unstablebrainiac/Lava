package macros;

import base.LambdaExpression;

import static base.LambdaExpression.*;

public class Booleans {

    // true := λx.λy.x
    public static final LambdaExpression TRUE = lambda(
            variable("x"),
            lambda(
                    variable("y"),
                    variable("x")
            )
    );

    // false := λx.λy.y
    public static final LambdaExpression FALSE = lambda(
            variable("x"),
            lambda(
                    variable("y"),
                    variable("y")
            )
    );

    // not := λb.b false true
    public static final LambdaExpression NOT = lambda(
            variable("b"),
            apply(
                    apply(
                            variable("b"),
                            FALSE
                    ),
                    TRUE
            )
    );

    public static LambdaExpression not(LambdaExpression b) {
        return apply(NOT, b);
    }

    // if := λb.λx.λy.b x y
    public static final LambdaExpression IF = lambda(
            variable("b"),
            lambda(
                    variable("x"),
                    lambda(
                            variable("y"),
                            apply(
                                    apply(
                                            variable("b"),
                                            variable("x")
                                    ),
                                    variable("y")
                            )
                    )
            )
    );

    public static LambdaExpression if_(LambdaExpression b, LambdaExpression x, LambdaExpression y) {
        return apply(apply(apply(IF, b), x), y);
    }

    // and := λx.λy. if x (if y true false) false
    public static final LambdaExpression AND = lambda(
            variable("x"),
            lambda(
                    variable("y"),
                    if_(variable("x"),
                            if_(variable("y"), TRUE, FALSE),
                            FALSE
                    )
            )
    );

    public static LambdaExpression and(LambdaExpression x, LambdaExpression y) {
        return apply(apply(AND, x), y);
    }

    // or := λx.λy. if x true (if y true false)
    public static final LambdaExpression OR = lambda(
            variable("x"),
            lambda(
                    variable("y"),
                    if_(variable("x"),
                            TRUE,
                            if_(variable("y"), TRUE, FALSE)
                    )
            )
    );

    public static LambdaExpression or(LambdaExpression x, LambdaExpression y) {
        return apply(apply(OR, x), y);
    }
}
