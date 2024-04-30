package macros;

import base.LambdaExpression;

import static base.LambdaExpression.*;
import static macros.Booleans.*;
import static macros.Nat.O;
import static macros.Nat.S;
import static macros.Pair.*;

public class Lists {

    // nil := λx.x
    public static final LambdaExpression NIL = lambda(variable("x"), variable("x"));

    // cons := λh. λt. pair false (pair h t)
    public static final LambdaExpression CONS = lambda(
            variable("h"),
            lambda(
                    variable("t"),
                    pair(FALSE, pair(variable("h"), variable("t")))
            )
    );

    public static LambdaExpression cons(LambdaExpression h, LambdaExpression t) {
        return apply(apply(CONS, h), t);
    }

    public static LambdaExpression list(LambdaExpression... elements) {
        LambdaExpression list = NIL;
        for (int i = elements.length - 1; i >= 0; i--) {
            list = cons(elements[i], list).reduce();
        }
        return list;
    }

    // head := λl. first (second l)
    public static final LambdaExpression HEAD = lambda(
            variable("l"),
            first(second(variable("l")))
    );

    public static LambdaExpression head(LambdaExpression l) {
        return apply(HEAD, l);
    }

    // tail := λl. second (second l)
    public static final LambdaExpression TAIL = lambda(
            variable("l"),
            second(second(variable("l")))
    );

    public static LambdaExpression tail(LambdaExpression l) {
        return apply(TAIL, l);
    }

    // isEmpty := λl. first l
    public static final LambdaExpression IS_EMPTY = lambda(
            variable("l"),
            first(variable("l"))
    );

    public static LambdaExpression isEmpty(LambdaExpression l) {
        return apply(IS_EMPTY, l);
    }
}
