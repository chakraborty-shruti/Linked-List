//Implementation and traversing a Linked List

class Node{
    int data;
    Node next; //Self referential structure (reference type in class)

    //Constructor to create a new node
    Node(int x){
        data = x;
        next = null;
    }
}

class ImplementationOfLinkedList{
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;

        printList(head);
    }

    //Traversing the given Linked List
    public static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data+ " ");
            curr = curr.next;
        }
    }
}

/*Output: 10 
20 
30 
40 
50 */