//Merging of Two Sorted Linked List in java

class Node{
    int data;
    Node next;

    Node(int k){
        data = k;
        next = null;
    }
}

class MergeTwoSortedLinkedList{

    static Node sortedMerge(Node a,Node b){
        if(a == null) return b;
        if (b == null) return a;

        Node head = null;
        Node tail = null;

        if(a.data <= b.data){
            head = tail = a;
        }else{
            head = tail = b;
        }

        while(a!= null && b!= null){
            if(a.data <= b.data){
                tail.next =  a;
                tail = a;
                a = a.next;
            }else{
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        if(a == null){
            tail.next = b;
        }else{
            tail.next = a;
        }
        return head;
    }

    static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data+" ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        //First sorted linked list: 1 -> 3 -> 5 ->7 -> null
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);

        // Second sorted linked list: 2 -> 4 -> 6 -> 8 -> null
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        Node head = null;
        head = sortedMerge(head1,head2);

        printList(head);
    }
}
