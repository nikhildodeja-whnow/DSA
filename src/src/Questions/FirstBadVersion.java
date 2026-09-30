package Questions;

/*
 * LeetCode 278 - First Bad Version
 *
 * Problem:
 * Given n versions [1, 2, 3, ..., n], one version is the first bad version.
 *
 * Once a version becomes bad, all versions after it are also bad.
 *
 * Example:
 *
 * n = 5
 * first bad version = 4
 *
 * Versions:
 * 1  2  3  4  5
 * G  G  G  B  B
 *
 * Answer = 4
 *
 * Approach:
 * Use Binary Search.
 *
 * If mid is a bad version:
 *     The first bad version can be mid or somewhere before mid.
 *     Therefore:
 *     right = mid
 *
 * If mid is a good version:
 *     The first bad version must be after mid.
 *     Therefore:
 *     left = mid + 1
 *
 * We continue until left == right.
 *
 * At that point, left/right represents the first bad version.
 *
 * Time Complexity:
 * O(log n)
 *
 * Space Complexity:
 * O(1)
 */

public class FirstBadVersion {

    // For this example, version 4 is the first bad version.
    static int firstBadVersionNumber = 11;

    // This method simulates LeetCode's isBadVersion API.
    public static boolean isBadVersion(int version) {
        return version >= firstBadVersionNumber;
    }

    public static int findFirstBadVersion(int n) {

        int left = 1;
        int right = n;

        // Continue until only one version remains
        while (left < right) {

            // Prevent integer overflow
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {

                // mid is bad.
                // First bad version can be mid or before mid.
                right = mid;

            } else {

                // mid is good.
                // First bad version must be after mid.
                left = mid + 1;
            }
        }

        // left == right
        // This is the first bad version.
        return left;
    }

    public static void main(String[] args) {

        int n = 14;

        int answer = findFirstBadVersion(n);

        System.out.println("First Bad Version = " + answer);
    }
}