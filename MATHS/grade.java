import java.util.Scanner;

class grade {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter marks: ");
            int num = sc.nextInt();

            if (num < 0 || num > 100) {
                System.out.println("Invalid marks");
            } else if (num >= 81) {
                System.out.println("A grade");
            } else if (num >= 61) {
                System.out.println("B grade");
            } else if (num >= 41) {
                System.out.println("C grade");
            } else if (num >= 21) {
                System.out.println("D grade");
            } else {
                System.out.println("E grade");
            }
        }
    }
}
