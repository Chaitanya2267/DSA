import java.util.Scanner;

public class MatrixOperation {
    public static void main(String[] args) {
        int[][] A = new int[10][10];
        int[][] B = new int[10][10];
        int[][] C = new int[10][10];

        int r1, c1, r2, c2;
        int choice, i, j, k;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("enter rows and columns of first matrix: ");
            r1 = sc.nextInt();
            c1 = sc.nextInt();

            System.out.println("enter elements of first matrix: ");
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            System.out.println("enter rows and columns of second matrix");
            r2 = sc.nextInt();
            c2 = sc.nextInt();

            System.out.println("enter elements of second matrix");
            for (i = 0; i < r2; i++) {
                for (j = 0; j < c2; j++) {
                    B[i][j] = sc.nextInt();
                }
            }
            do {
                System.out.println("matrix operation menu");
                System.out.println("1.matrix addition");
                System.out.println("2.matrix subtraction");
                System.out.println("3.matrix multiplication");
                System.out.println("0.exit");
                System.out.println("enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        if (r1 == r2 && c1 == c2) {
                            for (i = 0; i < r1; i++) {
                                for (j = 0; j < c1; j++) {
                                    C[i][j] = A[i][j] + B[i][j];
                                }
                            }
                            System.out.println("resultant matrix (addition): ");
                            for (i = 0; i < r1; i++) {
                                for (j = 0; j < c1; j++) {
                                    System.out.println(C[i][j] + " ");
                                }
                                System.out.println();
                            }
                        } else {
                            System.out.println("addition not possible. dimensions must be same.");
                        }
                        break;
                    }
                    case 2 -> {
                        if (r1 == r2 && c1 == c2) {
                            for (i = 0; i < r1; i++) {
                                for (j = 0; j < c1; j++) {
                                    C[i][j] = A[i][j] - B[i][j];
                                }
                            }
                            System.out.println("resultant matrix (subtraction): ");
                            for (i = 0; i < r1; i++) {
                                for (j = 0; j < c1; j++) {
                                    System.out.println(C[i][j] + " ");
                                }
                                System.out.println();
                            }
                        } else {
                            System.out.println("subtraction not possible. dimensions must be same.");
                        }
                        break;
                    }
                    case 3 -> {
                        if (r1 == c2) {
                            for (i = 0; i < r1; i++) {
                                for (j = 0; j < c2; j++) {
                                    C[i][j] = 0;
                                    for (k = 0; k < c1; k++) {
                                        C[i][j] += A[i][j] * B[i][j];
                                    }
                                }
                            }
                            System.out.println("resultant matrix (multiplication : ");
                            for (i = 0; i < r1; i++) {
                                for (j = 0; j < c2; j++) {
                                    System.out.println();
                                }
                            }
                        } else {
                            System.out.println("multiplication not possible");
                        }
                    }
                    case 0 -> {
                        System.out.println("exiting the program.");
                    }
                    default -> {
                        System.out.println("invalid choice");
                    }
                }
            } while (choice != 0);
        }
    }
}
