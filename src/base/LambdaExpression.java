package base;

public interface LambdaExpression {
    static Function lambda(Variable argument, LambdaExpression body) {
        return new Function(argument, body);
    }

    static Variable variable(String name) {
        return new Variable(name);
    }

    static Application apply(LambdaExpression function, LambdaExpression argument) {
        return new Application(function, argument);
    }

    LambdaExpression substitute(Variable argument, LambdaExpression replacement);

    boolean isReducible();

    LambdaExpression reduce();

    boolean contains(Variable variable);
}
