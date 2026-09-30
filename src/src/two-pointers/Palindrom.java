public  class Palindrom {

    public static boolean checkPalindrom(int[] arr) {
        int left=0, right = arr.length-1;
        while(left<right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,1};
        boolean isPalindrom = checkPalindrom(arr);
        System.out.println(isPalindrom);
    }
}