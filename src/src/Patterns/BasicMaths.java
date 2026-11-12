package Patterns;

public class BasicMaths {

    static void printDigits(int n) {
        while (n > 0) {
            int lastDigit = n % 10;
            System.out.print(lastDigit);
            n = n / 10;
        }
    }

    static int reverserNo(int n) {
        int reverseNo  = 0;
        while(n > 0) {
            int lastDigit = n % 10;
            n = n / 10;
            reverseNo = ( reverseNo * 10 ) + lastDigit;
        }
        return reverseNo;
    }

    static void armstrongNo(int n) {
        int armstrong  = 0;
        int no = n;
        int lenghtOfNo = (int)Math.log10(n)  + 1;
        while(n > 0) {
            int lastDigit = n % 10;
            n = n / 10;
            armstrong += Math.pow( lastDigit , lenghtOfNo);
        }
        if (armstrong == no) {
            System.out.println(no + " is armstrong no");
        } else {
            System.out.println(no + " is not armstrong no");
        }
    }

    static void isPrimeOptimized(int no) {
        if (no <= 1) {
            System.out.println("No " + no + " is prime no");
        }
        int sqrtOfNo = (int)Math.sqrt(no);
        for (int i = 2; i<= sqrtOfNo;  i++) {
            if (no % i == 0) {
                System.out.println("No " + no + " is prime no");
                break;
            }
        }
        System.out.println("No " + no + " is prime no");
    }

    static void printAllDivisor(int no) {
        // i x i <= no or Math.pow(i,2) <= no or below
        for (int i = 1; i <= Math.sqrt(no); i++) {
//            System.out.println("i * i => " + i * i);
            if (no % i == 0) {
                System.out.print(i + " "); // Print the first divisor

                // Print the paired divisor, unless it's a duplicate (like 6 * 6)
                if (i != no / i) {
                    System.out.print((no / i) + " ");
                }
            }
        }
    }

    public static int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        // Edge case: if one of the numbers is 0, GCD is the other number
        if (a == 0) return b;
        if (b == 0) return a;

        // Start checking from the smaller number down to 1
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i; // First common divisor found is the greatest
            }
        }

        return 1;
    }
    // Euclidean Algorithm.
    // o(log(max(n1,n2)))
    // gcd(n1, n2) = gcd(n1-n2, n2) if n1 > n2
    public static int findGCDForumlaBased(int n1, int n2) {
        n1 = Math.abs(n1);
        n2 = Math.abs(n2);

        if (n1 == 0) return n2;
        if (n2 == 0) return n1;

        // Keep subtracting the smaller number from the larger number
        while (n1 != n2) {
            if (n1 > n2) {
                n1 = n1 - n2;
            } else {
                n2 = n2 - n1;
            }
        }
        return n1; // When n1 == n2, that value is the GCD
    }
    // Euclidean Algorithm.
    // o(log(min(n1,n2)))
    public static int findGCDForumalBasedModulus(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return findGCDForumalBasedModulus(b, a % b);
    }

    public static void main(String[] args) {
        int no = 79980;
        printDigits(no);
        System.out.println("\n Length of " + no + " is " + ((int)Math.log10(no) + 1) + "\n");
        System.out.println("Reverse No Of 7744 => " + reverserNo(7744));
        armstrongNo(1635);
        printAllDivisor(36);
        int num1 = 48;
        int num2 = 36;
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + findGCD(num1, num2));
        System.out.println("GCD forumla based of " + num1 + " and " + num2 + " is: " + findGCDForumlaBased(num1, num2));
        System.out.println("GCD forumla based modulus of " + num1 + " and " + num2 + " is: " + findGCDForumalBasedModulus(num1, num2));


    }
}
