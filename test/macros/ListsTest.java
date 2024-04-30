package macros;

import base.LambdaExpression;
import org.junit.Test;

import static base.LambdaExpression.variable;
import static macros.Booleans.FALSE;
import static macros.Booleans.TRUE;
import static macros.Lists.*;
import static macros.Nat.*;

public class ListsTest {

    @Test
    public void testListHead1() {
        LambdaExpression list = list(variable("a"));
        LambdaExpression head = head(list);

        assert head.reduce().equals(variable("a"));
    }

    @Test
    public void testListHead2() {
        LambdaExpression list = list(variable("a"), variable("b"));
        LambdaExpression head = head(list);

        assert head.reduce().equals(variable("a"));
    }

    @Test
    public void testListHead3() {
        LambdaExpression list = list(variable("a"), variable("b"), variable("c"));
        LambdaExpression head = head(list);

        assert head.reduce().equals(variable("a"));
    }

    @Test
    public void testIsEmpty1() {
        LambdaExpression list = list(variable("a"));
        LambdaExpression isEmpty = isEmpty(list);

        assert isEmpty.reduce().equals(FALSE);
    }

    @Test
    public void testIsEmpty2() {
        LambdaExpression list = list(variable("a"), variable("b"));
        LambdaExpression isEmpty = isEmpty(list);

        assert isEmpty.reduce().equals(FALSE);
    }

    @Test
    public void testIsEmpty3() {
        LambdaExpression list = list();
        LambdaExpression isEmpty = isEmpty(list);

        assert isEmpty.reduce().equals(TRUE);
    }

    @Test
    public void testListTail1() {
        LambdaExpression list = list(variable("a"));
        LambdaExpression tail = tail(list);

        assert tail.reduce().equals(NIL);
    }

    @Test
    public void testListTail2() {
        LambdaExpression list = list(variable("a"), variable("b"));
        LambdaExpression tail = tail(list);

        assert tail.reduce().equals(list(variable("b")));
    }

    @Test
    public void testListTail3() {
        LambdaExpression list = list(variable("a"), variable("b"), variable("c"));
        LambdaExpression tail = tail(list);

        assert tail.reduce().equals(list(variable("b"), variable("c")));
    }
}
