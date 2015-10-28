package nyc.c4q.sufeiiz;

// Singly Linked List
public class SinglyNode {
    SinglyNode next;
    String data;

    public SinglyNode(String data) {
        this.data = data;
    }
}

class List {
    SinglyNode head;

    // DO NOT remove head reference to old 1. List will lose reference and be GC-ed
    public void addToHead(String data) {
        SinglyNode newNode = new SinglyNode(data);
        newNode.next = head;
        head = newNode;
    }

    // left side of = is arrow pointing to that node
    public void addToTail(String data) {
        SinglyNode newNode = new SinglyNode(data);

        SinglyNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insertAfter(String prevData, String newData) {
        SinglyNode current = head;
        while (current != null && !current.data.equals(prevData)) {
            current = current.next;
        }

        if (current != null) {
            SinglyNode newNode = new SinglyNode(newData);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void update(String oldData, String newData) {
        SinglyNode current = head;
        while (current != null && !current.data.equals(oldData)) {
            current = current.next;
        }

        if (current != null) {
            current.data = newData;
        }
    }

    public void delete(String data) {
        if (head == null) return;

        SinglyNode current = head;
        if (current.data.equals(data))
            head = current.next;

        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null)
            current.next = current.next.next;
    }

    public void printList() {
        SinglyNode current = head;

        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        List list = new List();


    }
}