package base;

import static base.LambdaExpression.apply;

public class Application implements LambdaExpression {
    private final LambdaExpression function;
    private final LambdaExpression argument;

    public Application(LambdaExpression function, LambdaExpression argument) {
        this.function = function;
        this.argument = argument;
    }

    public LambdaExpression getFunction() {
        return function;
    }

    public LambdaExpression getArgument() {
        return argument;
    }

    public boolean isReducible() {
        return function.isReducible() || argument.isReducible() || function instanceof Function;
    }

    public LambdaExpression reduce() {
        if (function.isReducible()) {
            return apply(function.reduce(), argument).reduce();
        } else if (argument.isReducible()) {
            return apply(function, argument.reduce()).reduce();
        } else if (function instanceof Function) {
            return ((Function) function).apply(argument).reduce();
        } else {
            return this;
        }
    }

    public LambdaExpression substitute(Variable argument, LambdaExpression replacement) {
        return apply(function.substitute(argument, replacement), this.argument.substitute(argument, replacement));
    }

    public boolean contains(Variable argument) {
        return function.contains(argument) || this.argument.contains(argument);
    }

    public String toString() {
        return "(" + function.toString() + " " + argument.toString() + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Application) {
            Application other = (Application) obj;
            return function.equals(other.function) && argument.equals(other.argument);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return function.hashCode() + argument.hashCode();
    }
}
