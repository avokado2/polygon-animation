package easing;

public class EaseInSine implements Easing {
    public class Ese {

    }
    @Override
    public double calculateKt(double t) {

        return 1 - Math.cos((t * Math.PI) / 2);
    }
}