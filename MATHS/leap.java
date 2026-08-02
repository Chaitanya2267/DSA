import java.util.Scanner;

class leap {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Year: ");
            int num = sc.nextInt();

            if (num % 400 == 0) {
                System.out.println("This is a leap year");
            } else if (num % 100 == 0) {
                System.out.println("This is not a leap year");
            } else if (num % 4 == 0) {
                System.out.println("This is a leap year");
            } else {
                System.out.println("This is not a leap year");
            }
        }
    }
}