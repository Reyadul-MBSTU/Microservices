package problemSolving;

public class LinedListImplementation {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head; //1->2->3->4;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node firstMove = head;
        //Node secondMove = head;
        while (firstMove.next != null) {
            firstMove = firstMove.next;
            //secondMove = secondMove.next;
        }
        firstMove.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node firstMove = head.next;
        Node secondMove = head;
        while (firstMove.next != null) {
            firstMove = firstMove.next;
            secondMove = secondMove.next;
        }
        secondMove.next = null;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public void printList(Node head) {
        if (head == null) {
            return;
        }
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public Node reverseLinkedListIterativeApproach() {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node reverseLinkedListRecursiveApproach(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node rev = reverseLinkedListRecursiveApproach(curr.next);
        curr.next.next = curr;
        curr.next = null;
        return rev;
    }

    public static void main(String[] args) {
        LinedListImplementation linedListImplementation = new LinedListImplementation();
        linedListImplementation.insert(10);
        linedListImplementation.insert(20);
        linedListImplementation.insert(30);
        ///  linedListImplementation.printList();
        linedListImplementation.addFirst(5);
        // linedListImplementation.printList();
        linedListImplementation.addLast(40);
        //  linedListImplementation.printList();
        linedListImplementation.deleteFirst();
        // linedListImplementation.printList();
        linedListImplementation.deleteLast();
        //linedListImplementation.printList();
        Node node = linedListImplementation.reverseLinkedListIterativeApproach();
        //linedListImplementation.printList(node);
        Node head = linedListImplementation.reverseLinkedListRecursiveApproach(node);
        linedListImplementation.printList(head);
    }
}
