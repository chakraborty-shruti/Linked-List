//Java code to Clone a linked List with next and random pointer by inserting nodes in place

class Node{
    int data;
    Node next, random;

    Node(int x){
        data = x;
        next = random = null;
    }
}

class Test{

    //Function to clone the linked list
    static Node cloneLinkedList(Node head){

        if(head == null){
            return null;
        }

        //Create new Node and insert them next to the original nodes
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        //Set the random pointers of the new nodes
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //Seperate the new nodes from the original
        curr = head;
        Node clonedHead = head.next;
        Node clone = clonedHead;

        while(clone.next != null){
            //Update the next nodes of the original node and cloned node
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;

        return clonedHead;
    }

    //Function to print the linked list
    static void printList(Node head){
        while(head != null){
            System.out.println(head.data+ "(");
            if(head.random != null){
                System.out.println(head.random.data);
            }else{
                System.out.println("null");
            }
            System.out.println(")");

            if(head.next != null){
                System.out.println("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        //Creating a linked List with random pointer
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        //Print the original list
        System.out.println("Original linked list");
        printList(head);

        //Function call
        Node clonedList = cloneLinkedList(head);

        System.out.println("Cloned linked list");
        printList(clonedList);
    }
}

/*Original linked list:
1(3) -> 2(1) -> 3(5) -> 4(3) -> 5(2)
Cloned linked list:
1(3) -> 2(1) -> 3(5) -> 4(3) -> 5(2) */