class Node{
    int  data ;
    Node next;

    Node(int x){
        data = x;
        next  = null;
    }
}

class PalindromeInLinkedList{

    static Node reverseList(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        return prev;
    }

    //Function to check if two list are identical
    static boolean isIdentical(Node n1, Node n2){
        while(n1 != null && n2 != null){
            if(n1.data != n2.data) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    static boolean isPalindrome(Node head){
        if(head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        //Slow goes and stop at the middle of the linked List after that the othe half of linked list is stored in slow.next 
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //We pass slow.next as the head of the linked list to be reversed
        Node head2 = reverseList(slow.next);
        slow.next = null;
        
        //After reversal we match the data of the linked list and check if data are equal or not .If the data is equal the list is pallindrome in nature
        boolean ret = isIdentical(head,head2);

        return ret;

    }

    public static void main(String[] args){
        //Linked List: 1->2->3->2->1->null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        
        boolean result = isPalindrome(head);

        if(result){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}