public class MyLinkedList<E> implements MyList<E> {
    private class MyNode {
        E data;
        MyNode next;
        MyNode prev;

        MyNode(E data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(E element) {
        MyNode newNode = new MyNode(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        MyNode newNode = new MyNode(element);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = head;
        } else if (index == size) {
            add(element);
            return;
        } else {
            MyNode current = getNode(index);
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public E remove(int index) {
        MyNode node = getNode(index);
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
        return node.data;
    }

    @Override
    public boolean remove(E element) {
        MyNode current = head;
        while (current != null) {
            if ((current.data == null && element == null) || (current.data != null && current.data.equals(element))) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;

                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if ((current.data == null && element == null) || (current.data != null && current.data.equals(element))) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}

