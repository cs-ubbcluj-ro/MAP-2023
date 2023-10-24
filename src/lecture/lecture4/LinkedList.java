package lecture.lecture4;

public class LinkedList<T> {

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

    public int size() {
        int _size = 0;

        if (this.head == null) {
            return 0;
        }

        Node current = this.head;
        while (current != null) {
            _size += 1;
            current = current.next;
        }
        return _size;
    }

    public IIterator<T> iterator() {
        return new ListIterator<T>(head);
    }

    /*
    Clasele imbricate sunt date membru in clasa externa (outer class)
    pot fi publice, private, etc.
     */
    class Node<T> {
        private Node<T> next;
        private T value;

        public Node(Node<T> next, T value) {
            this.next = next;
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }
    }

    class ListIterator<T> implements IIterator<T> {

        private Node<T> current;

        public ListIterator(Node<T> head) {
            this.current = head;
        }

        @Override
        public T getValue() {
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