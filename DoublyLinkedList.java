import java.util.ArrayList;

public class DoublyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> west;
        private Node<E> east;
        private Node<E> north;
        private Node<E> south;

        private Node(E e, Node<E> n, Node<E> ea, Node<E> w, Node<E> s) {
            element = e;
            north = n;
            east = ea;
            south = s;
            west = w;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNorth() {
            return north;
        }

        public Node<E> getEast() {
            return east;
        }

        public Node<E> getWest() {
            return west;
        }

        public Node<E> getSouth() {
            return south;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setNorth(Node<E> n) {
            north = n;
        }

        public void setEast(Node<E> n) {
            east = n;
        }

        public void setWest(Node<E> n) {
            west = n;
        }

        public void setSouth(Node<E> n) {
            south = n;
        }
    }

    private Node<E> root;
    private int size = 0;
    private Node<E> position;
    ArrayList<Object> repeats = new ArrayList<Object>();

    public DoublyLinkedList() {
        root = new Node<>(null, null, null, null, null);
        position = root;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // delete but here for reference
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // Node<E> newest = new Node<>(e, predecessor, successor);
        // predecessor.setNext(newest);
        // successor.setPrev(newest);
        // size++;
    }

    // my added methods
    public void Root(E letter) { // be generic here... ig?
        root = new Node<>(letter, null, null, null, null);
        position = root;
    }

    public void Add(E letter, String direction) {
        Node<E> cur = position;
        Node<E> newNode = new Node<>(null, null, null, null, null); // initialize outside of switch loop
        switch (direction) {
            case "north":
                newNode = new Node<>(letter, null, null, null, cur);
                cur.setNorth(newNode);
                break;
            case "east":
                newNode = new Node<>(letter, null, null, cur, null);
                cur.setEast(newNode);
                break;
            case "west":
                newNode = new Node<>(letter, null, cur, null, null);
                cur.setWest(newNode);
                break;
            case "south":
                newNode = new Node<>(letter, cur, null, null, null);
                cur.setSouth(newNode);
                break;
        }
        position = newNode; // move curPosition!
        size++;

    }

    public void Move(String direction) {
        switch (direction) {
            case "north":
                position = position.getNorth();
                break;
            case "east":
                position = position.getEast();
                break;
            case "west":
                position = position.getWest();
                break;
            case "south":
                position = position.getSouth();
                break;
        }
    }

    public boolean isUnique(ArrayList<Object> arr, E e) {
        if (e == null) {
            return false;
        }
        for (Object obj : arr) {
            if (e.equals((E) obj)) {
                return false;
            }
        }
        return true;
    }

    public void Print() {
        // cur position
        E letter = position.getElement();
        repeats.add(letter);
        System.out.print(letter);

        if (position.getNorth() != null && isUnique(repeats, position.getNorth().element)) {
            position = position.getNorth();
            Print();
            position = position.getSouth();// put back
        }

        if (position.getEast() != null && isUnique(repeats, position.getEast().element)) {
            position = position.getEast();
            Print();
            position = position.getWest();// put back
        }

        if (position.getSouth() != null && isUnique(repeats, position.getSouth().element)) {
            position = position.getSouth();
            Print();
            position = position.getNorth();
        }

        if (position.getWest() != null && isUnique(repeats, position.getWest().element)) {
            position = position.getWest();
            Print();
            position = position.getEast();// put back
        }

    }

}
