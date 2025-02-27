import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class LengthOfLoop{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        System.out.println("Enter the data inside the LL");
        Node head = new Node(sc.nextInt());
        Node tail = head;

        for(int i=0;i<n-1;i++){
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        System.out.println("Enter the pos of the node to which the last node to be connected");
        int pos = sc.nextInt();
        makeLoop(head,tail,pos);

        System.out.println("No of nodes in the Loop:"+ countNodesInLoop(head));
    }

    static void makeLoop(Node head, Node tail, int pos){
        if(pos ==0) return;
        Node curr = head;
        for(int i=1;i<pos;i++){
            curr = curr.next;
        }tail.next = curr;
    }

    static int countNodesInLoop(Node head){
        Node slow = head;
        Node fast = head;
        
        while (fast != null || fast.next != null) {
            slow = head.next;
            fast = head.next.next;
            if(slow == fast){
                return countLoopNode(slow);
            }
        }
        return 0;
    }

    static int countLoopNode(Node meetingPoint){
        Node curr = meetingPoint;
        int count = 1;

        while(curr != meetingPoint){
            count++;
            curr = curr.next;
        }
        return count;
    }
}