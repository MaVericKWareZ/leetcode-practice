public class PalindromeNumber {
    public static void main(String[] args) {
        int number = 12431;
        boolean res = isValidPalindrome(number);
        System.out.println("res = " + res);
    }

    public static boolean isValidPalindrome(int number) {
        int rev = 0;
        int temp = number;
        while (temp != 0) {
            int digit = temp % 10;
            rev = (rev * 10) + digit;
            temp = temp / 10;
        }
        System.out.println("rev = " + rev);
        return rev == number;
    }
}
