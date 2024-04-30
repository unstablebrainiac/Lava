package types;

@Deprecated
public class Pair<T extends LamdbaType> implements LamdbaType {
    private final T first;
    private final T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T extends LamdbaType> Pair<T> of(T first, T second) {
        return new Pair<>(first, second);
    }
}
