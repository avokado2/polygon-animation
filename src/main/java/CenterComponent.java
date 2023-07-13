import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CenterComponent extends JComponent {
    private Color color;
    private Point centre;
    private FigureComponent figureComponent;

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillOval(0, 0, 14, 14);
    }

    public CenterComponent(Color color, Point centre, FigureComponent figureComponent) {
        this.color = color;
        this.centre = centre;
        this.figureComponent = figureComponent;
        this.setBounds(centre.getX() - 7, centre.getY() - 7, centre.getX() + 7, centre.getY() + 7);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("Mouse dragged: " + e.getX() + ":" + e.getY());
                figureComponent.getFigure().move(e.getX(), e.getY());
                figureComponent.onFigureChanged();
            }
        });
    }

    public void setCentre(Point centre) {
        this.centre = centre;
        setBounds(centre.getX() - 7, centre.getY() - 7, 14, 14);
    }
}
