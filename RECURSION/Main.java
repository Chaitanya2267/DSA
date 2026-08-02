// 1.
// recursive function to print name count times
// class Solution {
//     public void printName(String s , int count , int N) {
//         if (count == N)
//             return ;
//         System.out.println(s);
//         printName(s, count + 1 , N);
//     }
// }

// public class Main {
//     public static void main(String args[]) {
//         Solution sol = new Solution();
//         int N = 5;
//         String s = "csw";
//         sol.printName(s, 0 , N);
//     }
// }


// 2.
// recursive function to print numbers from current to n 
// class Solution {
//     public void printNumber (int current, int N) {
//         if (current > N ) 
//             return ;
//         System.out.println(current + " ");
//         printNumber(current + 1 , N);
//     }
// }

// public class Main {
//     public static void main(String args[]) {
//         Solution sol = new Solution(); 
//         int N = 4;
//         sol.printNumber(1, N);
//         System.out.println();
//     }
// }


// 3.
// recursive function to print numbers from n to current
// class Solution {
//     public void printNumber(int current) {
//         if (current < 1)
//             return;
//         System.out.println(current + " ");
//         printNumber(current - 1);
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int n = 4;
//         sol.printNumber(n);
//         System.out.println();
//     }
// }


// 4.
// N to current using backtracking
// class Solution {
//     public void printNumber (int current , int N ) {
//         if (current > N) 
//             return ;
//         printNumber(current + 1, N);
//         System.out.println(current + " ");
//     }
// }

// public class Main {
//     public static void main(String args[]) {
//         Solution sol = new Solution();
//         int N = 4;
//         sol.printNumber(1, N);
//         System.out.println();
//     }
// }


// 5.
// current to N using backtracking
// class Solution {
//     public void printNumber(int current) {
//         if (current < 1)
//             return;
//         printNumber(current - 1);
//         System.out.println(current + " ");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int n = 4;
//         sol.printNumber(n);
//         System.out.println();
//     }
// }


// 6.
// calculating sum of natural number
// class Solution {
//     public int sumOfNaturalNum(int N) {
//         if (N == 1) {
//             return 1;
//         }
//         return N + sumOfNaturalNum(N - 1);
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         try (Scanner sc = new Scanner(System.in)) {
//             int N = sc.nextInt();
//             System.out.println(sol.sumOfNaturalNum(N));
//         }
//     }
// }


// 7.
// calculating factorial number 
// import java.util.Scanner;

// class Solution {
//     public int factorial (int N) {
//         if (N == 0) {
//             return 1;
//         }
//         return N * factorial (N - 1 );
//     }
// } 
// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         try (Scanner sc = new Scanner(System.in)) {
//             int N = sc.nextInt();
//             System.out.println(sol.factorial(N));
//         }
//     }
// }


// 8.
// calculating fibonachi number 
// import java.util.Scanner;
// class Solution {
//     public int fiboNum(int N) {
//         if (N <= 1) {
//             return N;
//         }
//         return fiboNum(N-1) + fiboNum(N-2);
//     }
// }
// public class Main {
//     public static void main(String args[]) {
//         Solution sol = new Solution();
//         try(Scanner sc = new Scanner(System.in)) {
//             int N = sc.nextInt();
//             System.out.println(sol.fiboNum(N));
//         }
//     }
// }


//9.
// reverse an array
// this is brute force approach
// class Solution {
//     public int[] reverseArray(int[] arr) {
//         int n = arr.length;
//         int[] ans = new int[n];
//         for(int i = 0; i < n ; i++) {
//             ans[i] = arr[n-i-1];
//         }
//         return ans;
//     }
// }
// public class Main {
//     public static void main(String[] args) {
//         int[] arr = {1,2,3,4,5};
//         Solution sol = new Solution();
//         int[] result = sol.reverseArray(arr);
//         System.out.println("Reverse Array: ");
//         for(int num : result) {
//             System.out.println(num + " ");
//         }
//         System.out.println();
//     }
// }

// this is better approach
// class Solution {
//     public void reverseArray(int[] arr) {
//         int p1 = 0;
//         int p2 = arr.length - 1;
//         while(p1 < p2) {
//             int temp = arr[p1];
//             arr[p1] = arr[p2];
//             arr[p2] = temp;
//             p1++;
//             p2--;
//         } 
//     }
// }
// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int[] arr = {1, 2, 3, 4, 5};
//         sol.reverseArray(arr);
//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//     }
// }


// 10.
// check if it is palindrome or not
// class Solution {
//     public boolean isPalindrome(String s) {
//         int left = 0 , right = s.length() - 1 ;
//         while(left<right) {
//             if(!Character.isLetterOrDigit(s.charAt(left))) left++;
//             else if(!Character.isLetterOrDigit(s.charAt(right))) right--;
//             else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
//             else {left++; right--;}
//         }
//         return true;
//     }
// }
// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         String str = "ABCDCBA";
//         boolean ans = sol.isPalindrome(str);
//         if(ans) {
//             System.out.println("Palindrome");
//         } else {
//             System.out.println("not Palindrome");
//         }
//     }
// }


// Solution class to check if a string is a palindrome using recursion
// class Solution {
//     public boolean palindrome(int i, String s) {
//         if (i >= s.length() / 2) return true;
//         if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
//         return palindrome(i + 1, s);
//     }
// }
// public class Main {
//     public static void main(String[] args) {
//         Solution solution = new Solution();  
//         String s = "madam"; 
//         System.out.println(solution.palindrome(0, s));  
//     }
// }
