package hello.models;

/**
 * Created by LevchukK.E. on 04.05.17.
 */
public class Coord {
    private final Float x;
    private final Float y;

    public Coord(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }
}
