public class SpiralMatrix54 {
    public static int[] spiralTravels(int[][] matrix) {
        int top = 0, left = 0;
        int bottom= matrix.length - 1, right=matrix[0].length - 1;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;
            // 3. Move Left across the bottom row (if a row remains)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                bottom--; // Move the bottom boundary up
            }
            // 4. Move Up along the left column (if a column remains)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++; // Move the left boundary right
            }
        }

        return result;

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10},{11,12,13,14,15}};
        int[] result = spiralTravels(matrix);
        System.out.println(java.util.Arrays.toString(result));

    }
}