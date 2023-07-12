import java.io.Serializable;
import java.util.Objects;


public class Point implements Serializable {
        private double x;
        private double y;
    public Point(){

    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point copy(){
        return new Point(x , y);
    }
    public void rotate(double alpha) {
        double xPrev = this.x;
        this.x = this.x * Math.cos(alpha) + this.y * Math.sin(alpha);
        this.y = this.y * Math.cos(alpha) - xPrev * Math.sin(alpha);

    }
    public void rotate(double alpha, Point rotateAxis) {
        this.x = this.x - rotateAxis.getX();
        this.y = this.y - rotateAxis.getY();
        this.rotate(alpha);
        this.x = this.x + rotateAxis.getX();
        this.y = this.y + rotateAxis.getY();
    }

    public void move(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public int getX() {
        return (int)Math.round(x);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return (int)Math.round(y);
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
