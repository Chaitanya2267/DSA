import java.util.Scanner;

class reversenum {
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number: ");
            int num = sc.nextInt();

            int reversedNum = 0;

            while (num != 0) {
            int digit = num % 10; // Get the last digit
            reversedNum = reversedNum * 10 + digit; // Append digit to reversedNum
            num /= 10; // Remove the last digit from num
            }
            System.out.println("Reversed number: " + reversedNum);
        }
    }
}