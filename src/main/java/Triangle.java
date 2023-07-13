public class Triangle extends Figure {

    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle() {

    }

    public Triangle(Point p1, Point p2, Point p3) {

        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;


    }


    @Override
    public double square() {
        double tr = 0.5 * (Math.abs((this.p2.getX() - this.p1.getX()) * (this.p3.getY() - this.p1.getY()) - (this.p3.getX() - this.p1.getX()) * (this.p2.getY() - this.p1.getY())));
        return tr;
    }

    @Override
    public void rotate(double alpha) {
        this.p1.rotate(alpha);
        this.p2.rotate(alpha);
        this.p3.rotate(alpha);
    }

    @Override
    public void rotate(double alpha, Point rotateAxis) {
        this.p1.rotate(alpha, rotateAxis);
        this.p2.rotate(alpha, rotateAxis);
        this.p3.rotate(alpha, rotateAxis);
    }

    @Override
    public Point getCenter() {
        double txc_1 = this.p1.getX() + this.p2.getX() + this.p3.getX();
        double txc = txc_1 / 3;
        double tyc_1 = this.p1.getY() + this.p2.getY() + this.p3.getY();
        double tyc = tyc_1 / 3;
        return new Point(txc, tyc);

    }

    @Override
    public void move(double deltaX, double deltaY) {
        this.p1.move(deltaX, deltaY);
        this.p2.move(deltaX, deltaY);
        this.p3.move(deltaX, deltaY);
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }
}