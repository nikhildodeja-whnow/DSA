package Patterns;

public class Nothing {


    static void recurrsion(int count) {
        count++;
        if (count > 3) {
            return;
        }
        System.out.println(count);
        recurrsion(count);
        System.out.println(count);
    }

    public static void main(String[] args) {
        recurrsion(0);
    }
}
