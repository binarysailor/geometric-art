package binarysailor.graphics;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static double getDouble() {
        return random.nextDouble();
    }

    public static double getBetweenZeroAnd(double max) {
        return max * random.nextDouble();
    }

    public static double getBetweenMinusAndPlus(double max) {
        return 2 * max * (random.nextDouble() - 0.5); 
    }

    public static double getBetween(double min, double max) {
        double range = Math.max(min, max) - Math.min(min, max);
        return min + getDouble() * range;
    }

    public static boolean getBoolean(double trueProbability) {
        return getDouble() <= trueProbability;
    }
}
