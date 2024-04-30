package base;

import static base.LambdaExpression.lambda;
import static base.LambdaExpression.variable;
import static util.VariableGenerator.next;

public class Function implements LambdaExpression {
    private final Variable argument;
    private final LambdaExpression body;

    public Function(Variable argument, LambdaExpression body) {
        this.argument = argument;
        this.body = body;
    }

    public Variable getArgument() {
        return argument;
    }

    public LambdaExpression getBody() {
        return body;
    }

    public boolean isReducible() {
        return body.isReducible();
    }

    public LambdaExpression reduce() {
        return lambda(argument, body.reduce());
    }

    private Function changeVariableName() {
        Variable newVariable = variable(next(argument.getName()));
        while (body.contains(newVariable)) {
            newVariable = variable(next(newVariable.getName()));
        }
        // alpha substitution
        return lambda(newVariable, body.substitute(argument, newVariable));
    }

    public LambdaExpression apply(LambdaExpression value) {
        if (value.contains(this.argument)) {
            return changeVariableName().apply(value);
        } else {
            return body.substitute(this.argument, value);
        }
    }

    public LambdaExpression substitute(Variable argument, LambdaExpression replacement) {
        if (argument.equals(this.argument)) {
            return this;
        } else {
            if (replacement.contains(this.argument)) {
                return changeVariableName().substitute(argument, replacement);
            } else {
                return lambda(this.argument, body.substitute(argument, replacement));
            }
        }
    }

    public boolean contains(Variable argument) {
        return this.argument.equals(argument) || body.contains(argument);
    }

    public String toString() {
        return "(λ " + argument.getName() + " . " + body.toString() + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Function) {
            Function other = (Function) obj;
            if (argument.equals(other.argument)) {
                return body.equals(other.body);
            } else {
                return body.equals(other.body.substitute(other.argument, argument));
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        return argument.hashCode() + body.hashCode();
    }
}
