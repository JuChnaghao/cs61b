public class LinkedListDeque<T>
{
    private static class Node<T>
    {
        public T item;
        public Node next;
        public Node last;
        public Node(T i, Node n, Node l)
        {
            item = i;
            next = n;
            last = l;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque()
    {
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.last = sentinel;
        size=0;
    }
    public void addFirst(T item)
    {
        size+=1;
        Node temp = new Node(item,null,null);
        temp.next = sentinel.next;
        sentinel.next.last = temp;
        sentinel.next = temp;
        temp.last = sentinel;
    }
    public void addLast(T item)
    {
        size+=1;
        Node temp = new Node(item,null,null);
        temp.last = sentinel.last;
        sentinel.last.next = temp;
        sentinel.last = temp;
        temp.next = sentinel;
    }
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        return false;
    }
    public int size()
    {
        return size;
    }
    public void printDeque()
    {
        Node p = sentinel.next;
        while(p != sentinel)
        {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }
    public T removeFirst()
    {
        if(size == 0)
        {
            return null;
        }
        else
        {
            size-=1;
            T temp = (T) sentinel.next.item;
            sentinel.next=sentinel.next.next;
            return temp;
        }
    }
    public T removeLast()
    {
        if(size == 0)
        {
            return null;
        }
        else
        {
            size-=1;
            T temp = (T) sentinel.last.item;
            sentinel.last=sentinel.last.last;
            return temp;
        }
    }
    public T get(int index)
    {
        Node p = sentinel;
        while(index >= 0)
        {
            p = p.next;
            index -= 1;
        }
        return (T) p.item;
    }
    public T getRecursive(int index)
    {
        return get(index);
    }
}
