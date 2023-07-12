import javax.swing.*;

public abstract class FigureComponent extends JComponent {

    public abstract Figure getFigure();
    public abstract void onFigureChanged();

}
