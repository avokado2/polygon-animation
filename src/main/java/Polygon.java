import java.util.ArrayList;
import java.util.List;

public class Polygon extends Figure {

    private List<Point> points;

    public Polygon(List<Point> points) {
        this.points = points;
    }

    private static final double triangleSquare(Point p1, Point p2, Point p3) {
        double tr = 0.5*(Math.abs((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p3.getX()-p1.getX()) * (p2.getY() - p1.getY())));
        return tr;
    }

    private static final Point triangleCenter(Point p1, Point p2, Point p3) {
        double txc_1 = p1.getX() + p2.getX() + p3.getX();
        double txc = txc_1/3;
        double tyc_1 = p1.getY() + p2.getY() + p3.getY();
        double tyc = tyc_1/3;
        return new Point(txc,tyc);
    }
    public Polygon copy(){
        List<Point> copy1 = new ArrayList<>();
        for (Point point: points){
            Point copyPoint = point.copy();
            copy1.add(copyPoint);
        }
        return new Polygon(copy1);
    }

    @Override
    public double square() {
        double ret = 0;
        for (int i = 0; i < points.size() - 2; i++) {
            ret += triangleSquare(points.get(0), points.get(i+1), points.get(i+2));
        }
        return ret;
    }

    @Override
    public void rotate(double alpha) {
        for (Point point : points) {
            point.rotate(alpha);
        }
    }

    @Override
    public void rotate(double alpha, Point rotateAxis) {
        for (Point point : points) {
            point.rotate(alpha, rotateAxis);
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public Point getCenter() {
        double cx = 0;
        double cy = 0;
        double a = 0;
        for (int i =0; i < points.size();i++) {
            int j = i+1;
            if (j == points.size()) {
                j = 0;
            }
            double xi = points.get(i).getX();
            double xi1 = points.get(j).getX();
            double yi = points.get(i).getY();
            double yi1 = points.get(j).getY();
            cx += (xi + xi1) * (xi * yi1 - xi1 * yi);
            cy += (yi + yi1) * (xi * yi1 - xi1 * yi);
            a += (xi * yi1 - xi1 * yi);
        }
        a = a/2;
        cx = cx / (6 * a);
        cy = cy / (6 * a);
        return new Point(cx, cy);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        for (Point point : points) {
            point.move(deltaX, deltaY);
        }
    }

    public static Polygon generate(Point center, int vertexCount, double radius) {
        List<Point> vertexList = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            Point vertex = new Point(center.getX(), center.getY() - radius);
            vertex.rotate(Math.PI * 2 * i / vertexCount, center);
            vertexList.add(vertex);
        }
        return new Polygon(vertexList);
    }
}
