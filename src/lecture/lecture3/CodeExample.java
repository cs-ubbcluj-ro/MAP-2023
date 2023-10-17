package lecture.lecture3;

interface IIterator {
    public Object getValue();

    public boolean isValid();

    public void nextNode();
}

class LinkedList<T> {

    private Node head;

    public void add(T elem) {

        if (head == null) {
            head = new Node(null, elem);
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node(null, elem));
    }

    public IIterator iterator() {
        return new ListIterator(head);
    }

    /*
    Clasele imbricate sunt date membru in clasa externa (outer class)
    pot fi publice, private, etc.
     */
    class Node {
        private Node next;
        private T value;

        public Node(Node next, T value) {
            this.next = next;
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }
    }

    class ListIterator implements IIterator {

        private Node current;

        public ListIterator(Node head) {
            this.current = head;
        }

        @Override
        public Object getValue() {
            // if current != null then current.value else null
            return (current != null ? current.value : null);
        }

        @Override
        public boolean isValid() {
            return current != null;
        }

        @Override
        public void nextNode() {
            if (current == null) {
                throw new NullPointerException("End of list");
            }

            current = current.getNext();
        }
    }
}

public class CodeExample {
    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        System.out.println(list.toString());

//        LinkedList.Node nod = new list.Node(null,null);
//        LinkedList.Node nod = list.new Node(null, null);
//        System.out.println(nod);

        list.add("Marius");
        list.add("Eugen");

        // Java autoboxing
        list.add(1234); // int e tip primitiv in Java !!??
        list.add(Integer.valueOf(9876));

        IIterator iter = list.iterator();
        while (iter.isValid()) {
            System.out.println(iter.getValue());
            iter.nextNode();
        }

//        java.util.LinkedList<String> javaList = new java.util.LinkedList<>();
//        javaList.add("123");
//        javaList.add("456");
//        javaList.add("789");
//
//        for (Object elem : javaList) {
//            System.out.println(elem);
//        }

//        System.out.println(iter.getValue());

    }
}
