import easing.EaseInOutElastic;
import easing.EaseInSine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class PolygonAnimation extends JFrame {
    private int index = 1;

    public PolygonAnimation() throws IOException, ClassNotFoundException {

        // создание окна
        super("Example LayeredTest");
        File file = new File("C:/users/vlad/IdeaProjects/test1/polygon/polygon.dat");
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
        java.util.List<Polygon> polygons = new ArrayList<>();
        for (int o = 0; o < 1000; o++) {
            try {
                polygons.add((Polygon) is.readObject());
            } catch (Exception ignore) {
            }
        }
        is.close();
        // выход при закрытии окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // определение многослойной панели
        JLayeredPane lp = getLayeredPane();
        //for (int i = 0; i < 20; i++) {
//            java.util.List<Point> points = new ArrayList<Point>();
//            points.add(new Point(150, 100));
//            points.add(new Point(200, 200));
//            points.add(new Point(150, 300));
//            points.add(new Point(100, 200));

        Polygon polygon = polygons.get(0);
        polygon = polygon.copy();
        PolygonComponent polygonComponent = new PolygonComponent(Color.red, polygon);
        polygonComponent.setEasing(new EaseInOutElastic());
        polygonComponent.setBounds(0, 0, 1600, 1650);
        lp.add(polygonComponent, JLayeredPane.POPUP_LAYER);

        JButton button = new JButton("test");
        lp.add(button, JLayeredPane.POPUP_LAYER);
        button.setBounds(0, 0, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index >= polygons.size()) {
                    index = 0;
                }
                Polygon pc = polygons.get(index);
                polygonComponent.animateto(pc, new AnimationCallback() {
                    @Override
                    public void onAnimationEnd() {
                        actionPerformed(e);
                    }
                });
                index++;

            }
        });

        //Triangle t = new Triangle(new Point(150, 100), new Point(100, 200), new Point(200, 200));
        //TriangleComponent figure = new TriangleComponent(Color.magenta, t);
        //t.rotate(2*Math.PI * i / 20, center);
        //figure.setBounds(0, 0, 600, 650);
        //lp.add(figure, JLayeredPane.POPUP_LAYER);

        //PolygonComponent figure2 = new PolygonComponent(Color.red, polygon);
        //figure2.setBounds(0, 0, 600, 650);
        //lp.add(figure2, JLayeredPane.POPUP_LAYER);
        //}
        // определение размера и открытие окна
        setSize(600, 650);
        setVisible(true);


    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        JFrame.setDefaultLookAndFeelDecorated(true);

        new PolygonAnimation();
    }

}