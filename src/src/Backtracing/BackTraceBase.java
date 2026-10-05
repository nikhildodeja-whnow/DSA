package Backtracing;

// 0 1 ka possible 2 binary combination
// 0 -> 00 -> 01
// 1 => 10 => 11
public class BackTraceBase {

    static void generate(String current) {

        // Agar length 2 ho gayi
        if (current.length() == 3) {
            System.out.println(current);
            return;
        } else {
            System.out.println(current);
        }

        // Choice 1: 0

        generate(current + "0");

        // Choice 2: 1
        generate(current + "1");
    }

    static void generate12(String current) {
        if (current.length() == 2) {
            System.out.println(current);
            return;
        }
        generate12(current + "1");
        generate12(current + "2");
    }

    public static void main(String[] args) {
//        generate("");
        generate12("");
    }
}