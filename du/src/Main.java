

/**
 * Created by daniil on 16.05.17.
 */
public class Main {
    public static double a = 0, b = 1;
    public static double y0 = 1;
    public static double h = 0.1;

    public static double func(double x, double y) {
        return 2 * (x * x + y);
    }

    public static void Runge_Kut(double h, double y0) {
        double x[] = new double[(int) ((b - a) / h) + 1];
        double tmp = a;
        double k1, k2, k3, k4;
        System.out.print("x: ");
        double d = 0;
        for (int i = 0; d <= b; d += h, tmp += h, i++) {
            x[i] = tmp;
        }
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%.3f ",x[i]);
        }
        System.out.println();

        double y[] = new double[(int) ((b - a) / h) + 1];
        y[0] = y0;

        for (int i = 0; i < x.length - 1; i++) {
            k1 = func(x[i], y[i]);
            k2 = func(x[i] + (h / 2), y[i] + ((h / 2) * k1));
            k3 = func(x[i] + (h / 2), y[i] + ((h / 2) * k2));
            k4 = func(x[i] + h, y[i] + (h * k3));
            y[i + 1] = y[i] + (h / 6) * (k1 + (2 * k2) + (2 * k3) + k4);
        }

        System.out.print("y: ");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%.3f ",y[i]);
        }
    }

    public static int Eiler_1(double h, double y0) {
        double x[] = new double[(int) ((b - a) / h) + 1];
        double tmp = a;
        System.out.print("x: ");
        double d = 0;
        for (int i = 0; d <= b; d += h, tmp += h, i++) {
            x[i] = tmp;
        }
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%.3f ",x[i]);
        }
        System.out.println();

        double y[] = new double[(int) ((b - a) / h) + 1];
        y[0] = y0;

        for (int i = 0; i < x.length - 1; i++) {
            y[i + 1] = y[i] + (h * func(x[i], y[i]));
        }
        System.out.print("y: ");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%.3f ",y[i]);
        }
        return 0;
    }

        public static void dvps() {

        }
    public static void main(String[] args) {

        System.out.println("Эйлер первого порядка: " );
        Eiler_1(h, y0);
        System.out.println();
        System.out.println("Рунге-Куте:");
        Runge_Kut(h, y0);
        //System.out.println("x: " + x[i]);




    }
}
