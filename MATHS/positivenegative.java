import java.util.Scanner;

class positivenegative {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number: ");
            int num = sc.nextInt();
            if (num == 0) {
                System.out.println(num + " is Zero.");
            } else if (num > 0) {
                System.out.println(num + " is Positive.");
            } else {
                System.out.println(num + " is Negative.");
            }
        }
    }
}
 