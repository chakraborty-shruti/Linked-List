class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Test{

    static Node intersectionNode(Node head1, Node head2){
        //Iterate over second List and for each node find it in the first list
        while(head2 != null){
            Node temp = head1;
            while(temp != null){
                if(temp == head2) return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }
    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);

        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);

        head2.next.next.next = head1.next;

        Node intersectionPoint = intersectionNode(head1,head2);

        if (intersectionPoint == null)
            System.out.println("-1");
        else
            System.out.println(intersectionPoint.data);
    }
}