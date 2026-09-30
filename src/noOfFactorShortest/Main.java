public class Main {

    public static void main(String[] args) {

        int count = 0;
        int n = 24;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println("i---" + i);
                count += (i * i == n) ? 1 : 2;
            }
        }

        System.out.println("Number of factors: " + count);
    }
}