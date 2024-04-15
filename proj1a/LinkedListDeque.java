import java.util.LinkedList;

public class LinkedListDeque<T> {
    public T item;
    public LinkedListDeque<T> next,front;
    public int size;
    public LinkedListDeque()
    {
        item = null;
        next = front = this;
        size = 0;
    }
    public void addFirst(T item)
    {
        LinkedListDeque<T> added = new LinkedListDeque<T>();
        LinkedListDeque<T> temp = new LinkedListDeque<T>();
        added.item = item;
        temp = this.next;
        this.next=added;
        added.front=this;
        temp.front=added;
        added.next=temp;
        size+=1;
    }
    public void addLast(T item)
    {
        LinkedListDeque<T> added = new LinkedListDeque<T>();
        LinkedListDeque<T> temp = new LinkedListDeque<T>();
        added.item = item;
        temp = this.front;
        this.front=added;
        added.next=this;
        temp.next=added;
        added.front=temp;
        size+=1;
    }
    public boolean isEmpty()
    {
        if(this.size==0)
            return true;
        return false;
    }
    public int size()
    {
        return this.size;
    }
    public void printDeque()
    {
        LinkedListDeque<T> flag=this.next;
        while(flag.item!=null)
        {
            System.out.print(flag.item + " ");
            flag=flag.next;
        }
    }
    public T removeFirst()
    {
        if(this.size==0)
            return null;
        else
        {
            T result=this.next.item;
            this.next.next.front=this;
            this.next=this.next.next;
            size-=1;
            return result;
        }
    }
    public T removeLast()
    {
        if(this.size==0)
            return null;
        else
        {
            T result=this.front.item;
            this.front.front.next=this;
            this.front=this.front.front;
            size-=1;
            return result;
        }
    }
    public T get(int index)
    {
        if (index>=this.size)
        {
            return null;
        }
        int result=0;
        LinkedListDeque<T> flag=this.next;
        while(result<index)
        {
            result+=1;
            flag=flag.next;
        }
        return flag.item;
    }
}
