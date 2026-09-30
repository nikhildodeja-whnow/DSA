public class BoundaryTraversal {

    public static int[] boundaryTraversal(int[][] matrix) {

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        int[] result = new int[2 * matrix.length + 2 * matrix[0].length - 4];
        int index = 0;

        // 1. Top row: left → right
        for (int i = left; i <= right; i++) {
            result[index++] = matrix[top][i];
        }

        // 2. Right column: top → bottom
        for (int i = top + 1; i <= bottom; i++) {
            result[index++] = matrix[i][right];
        }

        // 3. Bottom row: right → left
        for (int i = right - 1; i >= left; i--) {
            result[index++] = matrix[bottom][i];
        }

        // 4. Left column: bottom → top
        for (int i = bottom - 1; i > top; i--) {
            result[index++] = matrix[i][left];
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
        };

        int[] result = boundaryTraversal(matrix);

        System.out.println(java.util.Arrays.toString(result));
    }
}