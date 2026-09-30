package Questions;

public class RotateImage {

    // This method rotates the matrix 90 degrees clockwise
    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        /*
         * STEP 1: Transpose the matrix
         *
         * Transpose means:
         * matrix[i][j] <-> matrix[j][i]
         *
         * Example:
         *
         * 1 2 3        1 4 7
         * 4 5 6   ->   2 5 8
         * 7 8 9        3 6 9
         *
         * We start j from i + 1 so that:
         * 1. We don't swap diagonal elements.
         * 2. We don't swap the same pair twice.
         */
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                // Store matrix[i][j] temporarily
                int temp = matrix[i][j];

                // Put matrix[j][i] at matrix[i][j]
                matrix[i][j] = matrix[j][i];

                // Put original matrix[i][j] at matrix[j][i]
                matrix[j][i] = temp;
            }
        }

        /*
         * STEP 2: Reverse every row
         *
         * After transpose:
         *
         * 1 4 7
         * 2 5 8
         * 3 6 9
         *
         * Reverse each row:
         *
         * 7 4 1
         * 8 5 2
         * 9 6 3
         *
         * We use two pointers:
         * left  -> first element
         * right -> last element
         */
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            // Continue until the pointers meet
            while (left < right) {

                // Swap left and right elements
                int temp = matrix[i][left];

                matrix[i][left] = matrix[i][right];

                matrix[i][right] = temp;

                // Move pointers towards the center
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {

        // Create the input matrix
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Call rotate method
        rotate(matrix);

        // Print the rotated matrix
        System.out.println("Rotated Matrix:");

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            // Move to next row
            System.out.println();
        }
    }
}