import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class VertexComponent extends JComponent {
    private Color color;
    private Point centre;
    private FigureComponent figureComponent;
    private int index = 0;

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, 14, 14);
        g.setColor(Color.black);
        g.drawString("" + index, (index<10) ? 4 : 0,10);
    }
    public VertexComponent(Color color, Point centre, FigureComponent figureComponent, int i) {
        this.index = i;
        this.color = color;
        this.centre = centre;
        this.figureComponent = figureComponent;
        this.setBounds(centre.getX()-7, centre.getY()-7, centre.getX()+7, centre.getY()+7);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("Mouse dragged: " + e.getX() + ":" + e.getY());
                centre.setX(centre.getX() + e.getX());
                centre.setY(centre.getY() + e.getY());
                figureComponent.onFigureChanged();
            }
        });
    }

    public void setCentre(Point center) {
        this.centre = centre;
        setBounds(centre.getX() - 7, centre.getY() - 7, 14, 14);
    }
}
