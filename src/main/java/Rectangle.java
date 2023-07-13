public class Rectangle extends Figure {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    @Override
    public double square() {
        double rc_1 = 0.5 * (Math.abs((this.p2.getX() - this.p1.getX()) * (this.p3.getY() - this.p1.getY()) - (this.p3.getX() - this.p1.getX()) * (this.p2.getY() - this.p1.getY())));
        double rc_2 = 0.5 * (Math.abs((this.p2.getX() - this.p4.getX()) * (this.p3.getY() - this.p4.getY()) - (this.p3.getX() - this.p4.getX()) * (this.p2.getY() - this.p4.getY())));
        double rc = rc_1 + rc_2;
        return rc;
    }

    @Override
    public void rotate(double alpha) {
        this.p1.rotate(alpha);
        this.p2.rotate(alpha);
        this.p3.rotate(alpha);
        this.p4.rotate(alpha);
    }

    @Override
    public void rotate(double alpha, Point rotateAxis) {
        this.p1.rotate(alpha, rotateAxis);
        this.p2.rotate(alpha, rotateAxis);
        this.p3.rotate(alpha, rotateAxis);
        this.p4.rotate(alpha, rotateAxis);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        this.p1.move(deltaX, deltaY);
        this.p1.move(deltaX, deltaY);
        this.p1.move(deltaX, deltaY);
    }

    @Override
    public Point getCenter() {
        double rxc_1 = this.p1.getX() + this.p2.getX() + this.p3.getX() + this.p4.getX();
        double rxc = rxc_1 / 4;
        double ryc_1 = this.p1.getY() + this.p2.getY() + this.p3.getY() + this.p4.getY();
        double ryc = ryc_1 / 4;
        return new Point(rxc, ryc);
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

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }


}


