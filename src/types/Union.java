package types;

import java.util.function.Function;

@Deprecated
public interface Union<A extends LamdbaType, B extends LamdbaType> extends LamdbaType {

    class Left<A extends LamdbaType, B extends LamdbaType> implements Union<A, B> {
        public final A value;

        public Left(A value) {
            this.value = value;
        }
    }

    class Right<A extends LamdbaType, B extends LamdbaType> implements Union<A, B> {
        public final B value;

        public Right(B value) {
            this.value = value;
        }
    }

    static <A extends LamdbaType, B extends LamdbaType> Union<A, B> left(A value) {
        return new Left<>(value);
    }

    static <A extends LamdbaType, B extends LamdbaType> Union<A, B> right(B value) {
        return new Right<>(value);
    }

    default <R> R case_(Function<A, R> left, Function<B, R> right) {
        if (this instanceof Left) {
            return left.apply(((Left<A, B>) this).value);
        } else {
            return right.apply(((Right<A, B>) this).value);
        }
    }
}
