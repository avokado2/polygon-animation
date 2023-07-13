import java.io.Serializable;

public abstract class Figure implements Serializable {
    public abstract double square();

    public abstract void rotate(double alpha);

    public abstract void rotate(double alpha, Point rotateAxis);

    public abstract Point getCenter();

    public abstract void move(double deltaX, double deltaY);
}
