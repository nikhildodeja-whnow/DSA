public class Histogram {

    public static int largestRectangle(int[] heights) {

        int maxArea = 0;

        for (int left = 0; left < heights.length; left++) {

            int minHeight = Integer.MAX_VALUE;

            for (int right = left; right < heights.length; right++) {


                // Find minimum height
                minHeight = Math.min(minHeight, heights[right]);

                // Find width
                int width = right - left + 1;

                // Calculate area
                int area = minHeight * width;

                // Store maximum area
                maxArea = Math.max(maxArea, area);

            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 3, 2, 3};

        System.out.println(largestRectangle(heights));
    }
}