import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import easing.EaseInSine;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Triangle t = new Triangle(new Point(150, 100), new Point(100, 200), new Point(200, 200));
        Point point1 = new Point(10, 5);
        File file = new File("C:/users/vlad/desktop/2.dat");
       ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        os.writeObject(t);
        os.writeObject(point1);
        os.close();
       ObjectInputStream os1 = new ObjectInputStream(new FileInputStream(file));
       Triangle t2 = (Triangle) os1.readObject();
//        Point point3 = (Point) os1.readObject();
//        System.out.println(t.getP1().getX() + " " + t.getP1().getY());
//       System.out.println(point3.getX() + " " + point3.getY());

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
//        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        String json = objectMapper.writeValueAsString(t);
//        FileOutputStream j = new FileOutputStream(file);
//        j.write(json.getBytes());
//        j.close();
//        FileInputStream i = new FileInputStream(file);
//        byte[] ii = i.readAllBytes();
//        String json = new String(ii);
//        Triangle tt = objectMapper.readValue(json, Triangle.class);
//        System.out.println(tt.getP1().getX() + " " + tt.getP1().getY());
    }
}
