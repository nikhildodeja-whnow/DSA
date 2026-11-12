package Patterns;

public class Patterns {

    static void print1(int n) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    static void print2(int n) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }


    static void print3(int n) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j <= i ; j++) {
                System.out.print(j+1 + " ");
            }
            System.out.print("\n");
        }
    }

    static void print4(int n) {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.print(i+1 + " ");
            }
            System.out.print("\n");
        }
    }

    static void print5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    static void print6(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(j + 1 + " ");
            }
            System.out.print("\n");
        }
    }

    static void print7(int n) {
        for (int i = 0; i < n; i++) {
            int space = n - i - 1;
            for (int spaceI = 0; spaceI < space; spaceI++) {
                System.out.print(" ");
            }
            int star = i * 2 + 1;
            for (int starI = 0; starI < star; starI++) {
                System.out.print("*");
            }
//            System.out.printf("space %d star %d %n", space, star);
            for (int spaceI = 0; spaceI < space; spaceI++) {
                System.out.print(" ");
            }
            System.out.println();

        }
    }
    static void print8(int n) {
        for (int i = 0; i < n; i++) {
            for (int spaceI = 0; spaceI < i; spaceI++) {
                System.out.print(" ");
            }
            int star = (2*n) - (2 * i + 1);
            for (int starI = 0; starI < star; starI++) {
                System.out.print("*");
            }
            //            System.out.printf("space %d star %d %n", space, star);
            for (int spaceI = 0; spaceI < i; spaceI++) {
                System.out.print(" ");
            }
            System.out.println();

        }
    }

    static void print10(int n) {
        for(int i = 1; i <= 2 * n - 1; i++) {
            int start = i < n ?  i : 2 * n - i;
            for (int j = 1; j <= start ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void print11(int n) {

        for (int i = 0; i < n; i++) {
            int start = i %2 == 0 ? 1 : 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    static void print12(int n) {
        int space = 2 * n - 2;
        // or = 2 * (n-1)
        for (int i = 1; i <=n; i++) {
            // number

            for(int j = 1;j<=i; j++) {
                System.out.print(j);
            }
            // space
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            // number
            for(int j = i;j>=1; j--) {
                System.out.print(j);
            }
            System.out.println();
            space -= 2;
        }
    }

    static void print13(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for(int j = 0; j < i ; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    static void print14(int n) {
        for (int i = 1; i <= n; i++) {

            // or either we start j  from A and add A + i. it will be char intinalization nothing else
            for(int j = 0; j < i; j++) {
                System.out.printf("%c ", j + 65);
            }
            System.out.println();
        }
    }

    static void print15(int n) {
        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n-i; j++) {
//                System.out.printf("%c ", j + 65);
//            }
            for (char ch = 'A'; ch < 'A' + n-i; ch++) {
                System.out.printf("%c ", ch);
            }
            System.out.print("\n");
        }
    }

    static void print16(int n) {
        for (int i = 0; i < n; i++) {
            char c = (char) ('A' + i);
            for(int j = 0; j <= i; j++) {
                System.out.printf("%c ", c);
            }
            System.out.println();
        }
    }

    static void print17(int n) {
        for (int i = 0; i < n; i++) {
            int space = n - i - 1;
            for (int spaceI = 0; spaceI < space; spaceI++) {
                System.out.print(" ");
            }
            int star = i * 2 + 1;
            char ch = 'A';
            int breakpoint = ((2 * i) + 1) / 2;
            for (int j = 0; j < star; j++) {
                System.out.print(ch);
                if (j < breakpoint) ch++;
                else ch--;
            }
//            System.out.printf("space %d star %d %n", space, star);
            for (int spaceI = 0; spaceI < space; spaceI++) {
                System.out.print(" ");
            }
            System.out.println();

        }
    }

    static void print18(int n) {
        for (int i = 1; i <= n; i++) {

            // or either we start j  from A and add A + i. it will be char intinalization nothing else
            for(int j = n - i; j < n; j++) {
                System.out.printf("%c ", j + 65);
            }
            System.out.println();
        }
    }

    static void print19(int n) {
        int space = 0;
        for (int i = 0; i < n; i++) {
            //star
            for (int j=0; j<n-i; j++ ) {
                System.out.print("*");
            }

            //space
            for (int j=0; j<space; j++ ) {
                System.out.print(" ");
            }
            //star
            for (int j=0; j<n-i; j++ ) {
                System.out.print("*");
            }
            space+=2;
            System.out.println();
        }
        space = n * 2 - 2;
        for (int i = 0; i < n; i++) {
            //star
            for (int j=0; j<=i; j++ ) {
                System.out.print("*");
            }

            //space
            for (int j=0; j<space; j++ ) {
                System.out.print(" ");
            }
            //star
            for (int j=0; j<=i; j++ ) {
                System.out.print("*");
            }
            space-=2;
            System.out.println();
        }
    }

    static void print20(int n) {
        int space = n * 2 - 2;
        for(int i = 0; i <n; i++) {
            // star
            for(int j = 0; j<=i;j++) {
                System.out.print("*");
            }
            //space
            for(int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            //star
            for(int j = 0; j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
            space-=2;
        }
        space = Math.abs(space);
        for(int i = n-1; i>=1; i--) {
            // star
            for(int j = i; j>=1;j--) {
                System.out.print("*");
            }
            //space
            for(int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            //star
            for(int j = i; j>=1;j--) {
                System.out.print("*");
            }
            System.out.println();
            space += 2;
        }
    }

    static void print20Again(int n) {
        int space = 2 * n - 2;
        for(int i = 1; i < 2*n; i++) {
            // star
            int star = (i > n) ? i - space : i;
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            //space
            for(int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            //star
            // star
            for (int j = 1; j <= star; j++) {
                System.out.print("*");
            }
            if (i < n) {
                space -= 2;
            } else {
                space += 2;
            }
            System.out.println();

        }
    }

    static void print21(int n) {
        for(int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 || i == n-1 || j == 0 || j == n-1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void print22(int n) {
        int loopTimes = (n * 2 - 1);
        for (int i = 0; i < loopTimes; i++) {
            for(int j = 0; j < loopTimes; j++) {
                int top = i; // row
                int left = j; // col
                int right = (2*n -1) -1 - j; // right distance
                int bottom = (2*n - 1) -1 -i; // left distance
                int minValue = Math.min(Math.min(top, bottom), Math.min(left, right));
                int printValue = n - minValue;
                System.out.print(printValue + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("\nPattern 1\n");
        print1(n);
        System.out.println("\nPattern 2\n");
        print2(n);
        System.out.println("\nPattern 3\n");
        print3(n);
        System.out.println("\nPattern 4\n");
        print4(n);
        System.out.println("\nPattern 5\n");
        print5(n);
        System.out.println("\nPattern 6\n");
        print6(n);
        System.out.println("\nPattern 7\n");
        print7(n);
        System.out.println("\nPattern 8\n");
        print8(n);
        System.out.println("\nPattern 9\n");
        print7(n);
        print8(n);
        System.out.println("\nPattern 10\n");
        print10(n);
        System.out.println("\nPattern 11\n");
        print11(n);
        System.out.println("\nPattern 12\n");
        print12(n);
        System.out.println("\nPattern 13\n");
        print13(n);
        System.out.println("\nPattern 14\n");
        print14(n);
        System.out.println("\nPattern 15\n");
        print15(n);
        System.out.println("\nPattern 16\n");
        print16(n);
        System.out.println("\nPattern 17\n");
        print17(n);
        System.out.println("\nPattern 18\n");
        print18(n);
        System.out.println("\nPattern 19\n");
        print19(n);
        System.out.println("\nPattern 20\n");
        print20(n);
        System.out.println("\nPattern 20 Again\n");
        print20Again(n);
        System.out.println("\nPattern 21\n");
        print21(n);
        System.out.println("\nPattern 22\n");
        print22(n);
    }
}
