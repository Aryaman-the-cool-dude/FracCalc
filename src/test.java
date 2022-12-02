public class test {

    public static void main(String[] args) {
        // reduceFraction(15, 10);
        int x = -6/-5;
        System.out.println(x);
    }
    public static void reduceFraction(int x, int y)
    {
        int d;
        d = gcd(x, y);

        x = x / d;
        y = y / d;

        System.out.println("x = " + x + ", y = " + y);
    }

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }

}
