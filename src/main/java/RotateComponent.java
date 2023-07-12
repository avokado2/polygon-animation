import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RotateComponent extends JComponent {
    private Color color;
    private Point centre;
    private FigureComponent figureComponent;
    private Polygon polygon;

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(color);
        int[] xcoordinates = new int[4];
        int[] ycoordinates = new int[4];
        xcoordinates[0] = 7;
        ycoordinates[0] = 0;
        xcoordinates[1] = 14;
        ycoordinates[1] = 7;
        xcoordinates[2] = 7;
        ycoordinates[2] = 14;
        xcoordinates[3] = 0;
        ycoordinates[3] = 7;
        g.fillPolygon(xcoordinates, ycoordinates, xcoordinates.length);

    }

    public RotateComponent(Color color, Polygon polygon, FigureComponent figureComponent) {
        this.color = color;
        this.centre = polygon.getCenter();
        this.figureComponent = figureComponent;
        this.polygon = polygon;

        this.setBounds(((polygon.getCenter().getX() + polygon.getPoints().get(0).getX()) / 2) - 7,
                ((polygon.getCenter().getY() + polygon.getPoints().get(0).getY()) / 2) - 7, 14, 14);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("Mouse dragged: " + e.getX() + ":" + e.getY());
                int xc = polygon.getCenter().getX();
                int yc = polygon.getCenter().getY();
                int x0 = polygon.getPoints().get(0).getX();
                int y0 = polygon.getPoints().get(0).getY();
                int x0M =  x0 + e.getX();
                int y0M = y0 + e.getY();

                //переносим систему координат в точку хс ус
                x0 -= xc;
                y0 -= yc;
                x0M -= xc;
                y0M -= yc;

                //вычесляем угол а угол вектора х0 у0 а в это х0М у0М в радианах
                double a = Math.atan2(x0, y0);
                double b = Math.atan2(x0M, y0M);
                // угол поворота с это разность между углами в и а
                double c = b - a;
                polygon.rotate(c, centre);
                figureComponent.onFigureChanged();
            }
        });


    }

    public void setCentre(Point centre) {
        this.centre = centre;
        setBounds( ((polygon.getCenter().getX() + polygon.getPoints().get(0).getX()) / 2)- 7, ((polygon.getCenter().getY() + polygon.getPoints().get(0).getY()) / 2) - 7, 14, 14);
    }
}

