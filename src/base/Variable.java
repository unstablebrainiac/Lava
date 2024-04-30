package base;

public class Variable implements LambdaExpression {
    private final String name;

    public Variable(String name) {
        if (name.contains("λ")) {
            throw new IllegalArgumentException("Variable name cannot contain λ");
        }
        if (name.contains(".")) {
            throw new IllegalArgumentException("Variable name cannot contain a dot");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isReducible() {
        return false;
    }

    public LambdaExpression reduce() {
        return this;
    }

    public LambdaExpression substitute(Variable argument, LambdaExpression replacement) {
        if (this.equals(argument)) {
            return replacement;
        } else {
            return this;
        }
    }

    public boolean contains(Variable argument) {
        return this.equals(argument);
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Variable) {
            return name.equals(((Variable) obj).name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return name.hashCode();
    }
}
