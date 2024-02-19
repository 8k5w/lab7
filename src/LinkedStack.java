public class LinkedStack <E>implements Stack<E>{
    CircularlyLinkedList<E>l=new CircularlyLinkedList<>();


    @Override
    public int size() {
        return l.size();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public void push(E e) {
        l.addFirst(e);
    }

    @Override
    public E pop() {
        return l.removeFirst();
    }

    @Override
    public E top() {
        return l.first();
    }
    public static void transfer(Stack<Integer> S, Stack<Integer> T) {
        while (!S.isEmpty()) {
            int element = S.pop();
            T.push(element);
        }
    }

    public void removeAll() {
        if (! isEmpty()) {
            this.pop();
            this.removeAll();
        }
    }

}
