import javax.swing.*;
import java.awt.*;

public class TriangleComponent extends FigureComponent {
    private Color color;
    private Triangle triangle;
    private VertexComponent v1;
    private VertexComponent v2;
    private VertexComponent v3;
    private CenterComponent center;


    @Override
    protected void paintComponent(Graphics g) {
        Point p1 = triangle.getP1();
        Point p2 = triangle.getP2();
        Point p3 = triangle.getP3();
        g.setColor(color);
        g.drawPolygon(new int[]{p1.getX(), p2.getX(), p3.getX()},
                new int[]{p1.getY(), p2.getY(), p3.getY()}, 3);

    }


    public TriangleComponent(Color color, Triangle triangle) {
        this.color = color;
        this.triangle = triangle;
        this.v1 = new VertexComponent(color, triangle.getP1(), this, 0);
        this.add(v1);
        this.v2 = new VertexComponent(color, triangle.getP2(), this, 1);
        this.add(v2);
        this.v3 = new VertexComponent(color, triangle.getP3(), this, 2);
        this.add(v3);
        this.center = new CenterComponent(color, triangle.getCenter(), this);
        this.add(center);
    }

    @Override
    public void onFigureChanged() {
        this.center.setCentre(triangle.getCenter());
        this.v1.setCentre(triangle.getP1());
        this.v2.setCentre(triangle.getP2());
        this.v3.setCentre(triangle.getP3());
        this.repaint();
        this.center.repaint();
        this.v1.repaint();
        this.v2.repaint();
        this.v3.repaint();

    }

    @Override
    public Figure getFigure() {
        return triangle;
    }
}
