class Node{
    int data;
    Node next;

    Node(int k){
        data = k;
        next = null;
    }
}

class ReverseOfLinkedList{

   // 1 -> 2 -> 3 -> 4 -> 5 -> null
   //On Reversing
   // null <- 1<- 2 <- 3 <- 4 <- 5

   //next temporary holds the next node and prev stores the previous node. 

    static Node reverseList(Node head){
        Node curr = head;
        Node next = null;
        Node prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data+" ");
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Print the list of linked List");
        printList(head);

        head = reverseList(head);

        System.out.println("Revsesed Linked List");
        printList(head);

    }
}