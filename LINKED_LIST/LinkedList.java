/**
 * LinkedList
 */
class Node{
    int data;
    Node next;

    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class LinkedList {

    private static Node convertArr2LL(int[] arr){
        if(arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void printLL(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static int lengthofLL(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private static boolean checkIfPresent(Node head, int val){
        Node temp = head;
        while(temp != null) {
            if(temp.data == val) return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};

        Node head = convertArr2LL(arr);
        
        System.out.println("Linked List: ");
        printLL(head);

        System.out.println("Length: " + lengthofLL(head));

        int target = 5;
        System.out.println("Is" + target + "present? " + checkIfPresent(head, target));
    }
}