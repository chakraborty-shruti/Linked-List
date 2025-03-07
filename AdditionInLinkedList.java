
class Node{
    int data;
    Node next;

    Node(int val){
        data = val;
        next = null;
    }
}

class Test{

    //Function to reverse list
    /*The input numbers are stored in forward order (most significant digit first). However, when we add numbers manually, we start from the least significant digit (rightmost digit).

    To simplify the addition process, we reverse both linked lists so that we can add digits starting from the least significant position */
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //Function to trim leading zeros in linked list
    static Node trimLeadingZeros(Node head){
        while(head!= null && head.data == 0){
            head = head.next;
        }
        return head;
    }

    //Function to add two numbers represented by linked list
    static Node addTwoLists(Node num1, Node num2){
        Node res = null;
        Node curr = null;
        int carry = 0;

        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);

        num1 = reverse(num1);
        num2 = reverse(num2);

        //Iterate till either num1 is not empty or num2 is not empty or carry is greater than 0
        while(num1 != null || num2 != null || carry != 0){
            int sum = carry;

            if(num1!= null){
                sum += num1.data;
                num1 = num1.next;
            }

            if(num2 != null){
                sum += num2.data;
                num2 = num2.next;
            }

            Node newNode = new Node(sum%10);
            carry = sum/10;

            //If this is the first node, then make this node as the head of the resultant linked list otherwise append new node to resultant linked list
            if(res == null){
                res = newNode;
                curr = newNode;
            }else{
                curr.next = newNode;
                curr = curr.next;
            }
        }
        return reverse(res);
    }

    static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data+ " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void  main(String[] args){

        //Creating first Linked List: 1->2->3 (represents 123)
        Node num1 = new Node(1);
        num1.next = new Node(2);
        num1.next.next = new Node(3);

        //Creating second Linked List: 9->9->9 (represents 999)
        Node num2 = new Node(9);
        num2.next = new Node(9);
        num2.next.next = new Node(9);

        Node sum = addTwoLists(num1, num2);
        printList(sum);
    }
}
/* num1 ; 3->4->2(rerpesents 243)
    num2 : 4->6->5(represents 564)
    
Iteration 1 (Adding first digits: 3 + 4)
sum = carry → sum = 0
sum += num1.data (3) → sum = 3
sum += num2.data (4) → sum = 7
Create new node with value 7 % 10 = 7
carry = 7 / 10 = 0
Result list: 7

Iteration 2 (Adding second digits: 4 + 6)
sum = carry (0)
sum += num1.data (4) → sum = 4
sum += num2.data (6) → sum = 10
Create new node with value 10 % 10 = 0
carry = 10 / 10 = 1
Result list: 7 -> 0

Iteration 3 (Adding third digits: 2 + 5)
sum = carry (1)
sum += num1.data (2) → sum = 3
sum += num2.data (5) → sum = 8
Create new node with value 8 % 10 = 8
carry = 8 / 10 = 0
Result list: 7 -> 0 -> 8
 */