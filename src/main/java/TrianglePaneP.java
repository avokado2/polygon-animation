import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.io.*;



public class TrianglePaneP extends JFrame{

    private  ObjectOutputStream os;
    private static final long serialVersionUID=1L;
    public TrianglePaneP () throws IOException {

        // создание окна
        super("Example LayeredTest");
        File file = new File("C:/users/vlad/IdeaProjects/test1/polygon/polygon.dat");
        os = new ObjectOutputStream(new FileOutputStream(file));
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // выход при закрытии окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // определение многослойной панели
        JLayeredPane lp=getLayeredPane();
        //for (int i = 0; i < 20; i++) {
//            java.util.List<Point> points = new ArrayList<Point>();
//            points.add(new Point(150, 100));
//            points.add(new Point(200, 200));
//            points.add(new Point(150, 300));
//            points.add(new Point(100, 200));

            Polygon polygon = Polygon.generate(new Point(300, 300), 20, 200);
            PolygonComponent polygonComponent = new PolygonComponent(Color.red, polygon);
            polygonComponent.setBounds(0, 0, 600, 650);
            lp.add(polygonComponent, JLayeredPane.POPUP_LAYER);

            JButton button = new JButton("save/add");
            lp.add(button, JLayeredPane.POPUP_LAYER);
            button.setBounds(0, 0, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    os.writeObject(polygon.copy());
                    System.out.println("save");
                } catch (IOException ex) {
                }
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
        setSize(600,650);
        setVisible(true);


    }
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        JFrame.setDefaultLookAndFeelDecorated(true);

        new TrianglePaneP();
    }

}