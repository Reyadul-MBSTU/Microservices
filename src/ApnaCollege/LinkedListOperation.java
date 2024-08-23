package ApnaCollege;

public class LinkedListOperation {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node addNode = head;
        while (addNode.next != null) {
            addNode = addNode.next;
        }
        addNode.next = newNode;
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
        Node lastNode = head;
        //Node secondLastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            // secondLastNode = secondLastNode.next;
        }
        lastNode.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
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
        Node lastNode = head.next;
        Node secondLast = head;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    private Node reverseLinkedListIterativeApproach() {
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

    private Node reverseLinkedListRecursiveApproach(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node curr = node;
        Node newNode = reverseLinkedListRecursiveApproach(curr.next);
        curr.next.next = curr;
        curr.next = null;
        return newNode;
    }


    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
        }
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print(node.data);
        System.out.println();
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
        }
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print(node.data);
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListOperation linkedListOperation = new LinkedListOperation();
//        linkedListOperation.addFirst(2);
//        linkedListOperation.printList();
//        linkedListOperation.addFirst(3);//3->2
//        linkedListOperation.printList();
//        linkedListOperation.addLast(4);
//        linkedListOperation.printList();
//        linkedListOperation.addLast(5);
//        linkedListOperation.printList();
//        linkedListOperation.deleteFirst();
//        linkedListOperation.printList();
//        linkedListOperation.deleteLast();
//        linkedListOperation.printList();
        linkedListOperation.add(1);
        linkedListOperation.add(2);
        linkedListOperation.add(3);
        linkedListOperation.printList();
        Node node = linkedListOperation.reverseLinkedListIterativeApproach();
        linkedListOperation.printList(node);
        Node node1 = linkedListOperation.reverseLinkedListRecursiveApproach(node);
        linkedListOperation.printList(node1);
    }


}
