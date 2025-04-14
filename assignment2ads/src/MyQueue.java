public class MyQueue<E> {
    private MyLinkedList<E> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(E element) {
        list.add(element); // добавляем в конец
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return list.remove(0); // удаляем с начала
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}

