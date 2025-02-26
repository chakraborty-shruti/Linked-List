import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class CountingNodesOfLinkedList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = new Node(sc.nextInt());
        Node tail = head;

        for(int i=0;i<n-1;i++){
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }
        System.out.println(getCount(head));
        printList(head);
    }

    public static int getCount(Node head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data+" ");
            curr = curr.next;
        }
    }
}
