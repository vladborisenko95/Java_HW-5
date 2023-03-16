import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
        // int[] a = new int[] { 1, 2, 3, 2, 1 };
        // int[] b = new int[] { 3, 2, 1, 4, 7 };

        int[] a = new int[] { 0, 0, 0, 0, 0 };
        int[] b = new int[] { 0, 0, 0, 0, 0, 0 };

        // int[] a = new int[] { 3,6,5,1,5,6,8,7,9,7,4 };
        // int[] b = new int[] { 3,6,4,7,4,9,8,7,9,7,4 };

        // int[] a = new int[] { 6, 8, 7, 9, 7, 4 };
        // int[] b = new int[] { 9, 8, 7, 9, 7, 4 };

        System.out.println(findLengthThroghSet(a, b));
        System.out.println(findLengthThroghTwoDimArray(a, b));

    }

    //метод решения через HashSat
    public static int findLengthThroghSet(int[] nums1, int[] nums2) {
        Set<List<Integer>> set = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length + 1; j++) {
                List<Integer> sub = new ArrayList<>();
                for (int k = i; k < j; k++) {
                    sub.add(nums1[k]);
                }
                set.add(sub);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length + 1; j++) {
                List<Integer> sub = new ArrayList<>();
                for (int k = i; k < j; k++) {
                    sub.add(nums2[k]);

                }
                if (set.contains(sub)) {
                    maxLength = Math.max(maxLength, sub.size());
                }
            }
        }

        return maxLength;

    }
    // метод через двумерный массив
    public static int findLengthThroghTwoDimArray(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int maxLength = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

    // с помощю двух указателей
    public static int findLength(int[] nums1, int[] nums2) {
        int maxLength = 0;
        for (int i = 0; i < nums1.length; i++) {
            int p1 = i;
            int p2 = 0;
            int len = 0;
            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] == nums2[p2]) {
                    len++;
                    maxLength = Math.max(maxLength, len);
                } else {
                    len = 0;
                }
                p1++;
                p2++;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            int p1 = 0;
            int p2 = i;
            int len = 0;
            while (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] == nums2[p2]) {
                    len++;
                    maxLength = Math.max(maxLength, len);
                } else {
                    len = 0;
                }
                p1++;
                p2++;
            }
        }
        return maxLength;
    }

}