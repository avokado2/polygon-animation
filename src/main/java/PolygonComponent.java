import easing.Easing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PolygonComponent extends FigureComponent {

    private Color color;
    private Polygon polygon;
    private CenterComponent center;
    private List<VertexComponent> vList = new ArrayList<>();
    private int animateCounter;
    private Timer timer;
    private RotateComponent rotate;

    public Easing getEasing() {
        return easing;
    }


    public void setEasing(Easing easing) {

        this.easing = easing;

    }

    private Easing easing;

    public int calculateAnimationCor(int a, int b, int totalCount, int counter){
        //
        double k = ((double) counter) / totalCount;
        k = 1 - k;
        k = easing.calculateKt(k);
        if (a > b) {
            double ab = a - b;
            return (int) Math.round(a - k * ab);
        }else {
            double ab = b - a;
            return (int) Math.round(a + k * ab);
        }
    }
    public void animateto(Polygon dest, AnimationCallback callback){
        Polygon polygonc = polygon.copy();
        animateCounter = 62;

        this.timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < polygonc.getPoints().size(); i++) {
                    int x1 = polygonc.getPoints().get(i).getX();
                    int y1 = polygonc.getPoints().get(i).getY();
                    int x2 = dest.getPoints().get(i).getX();
                    int y2 = dest.getPoints().get(i).getY();
                    int x = calculateAnimationCor(x1, x2, 62, animateCounter);
                    int y = calculateAnimationCor(y1, y2, 62, animateCounter);
                    polygon.getPoints().get(i).setX(x);
                    polygon.getPoints().get(i).setY(y);
                }
                animateCounter--;
                onFigureChanged();
                if (animateCounter == 0 ) {
                    timer.stop();
                    callback.onAnimationEnd();
                }
            }
        });
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        int[] xcoordinates = new int[polygon.getPoints().size()];
        int[] ycoordinates = new int[polygon.getPoints().size()];
        for (int i = 0; i < polygon.getPoints().size(); i++) {
            Point point = polygon.getPoints().get(i);
            xcoordinates[i] = point.getX();
            ycoordinates[i] = point.getY();
        }
        g.setColor(color);
        g.drawPolygon(xcoordinates, ycoordinates, xcoordinates.length);
    }

    public PolygonComponent(Color color, Polygon polygon) {
        this.color = color;
        this.polygon = polygon;
        int i =0;
        for (Point point : polygon.getPoints()) {
            VertexComponent v = new VertexComponent(color, point, this, i);
            i++;
            this.vList.add(v);
            this.add(v);
        }
        this.center = new CenterComponent(color, polygon.getCenter(), this);
        this.add(center);

        this.rotate = new RotateComponent(color,polygon, this);
        this.add(rotate);
    }

    @Override
    public void onFigureChanged() {
        this.center.setCentre(polygon.getCenter());
        for (int i = 0; i < polygon.getPoints().size(); i++) {
            this.vList.get(i).setCentre(polygon.getPoints().get(i));
        }
        this.rotate.setCentre(polygon.getCenter());
        this.repaint();
        this.center.repaint();
        this.repaint();
        this.rotate.repaint();
        for (VertexComponent vertexComponent : this.vList) {
            vertexComponent.repaint();
        }
    }

    @Override
    public Figure getFigure() {
        return polygon;
    }
}
