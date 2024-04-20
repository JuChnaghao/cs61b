public class ArrayDeque<T> {
    private int size;
    private int start,top;
    private T[] memory ;
    private int length;
    public ArrayDeque()
    {
        length = 8;
        size = 0;
        start = length - 1;
        top = 0;
        memory = (T[]) new Object[8];
    }
    private void resize(int capacity)
    {
        if(start + 1 >= top)
        {
            T[] narray = (T[]) new Object[capacity];
            System.arraycopy(memory,0,narray,0,top);
            System.arraycopy(memory,start+1,narray,capacity-memory.length+start+1,memory.length-start-1);
            memory = narray;
            length = capacity;
            start = length - 1 - (size-top);
        }
        else
        {
            T[] narray = (T[]) new Object[capacity];
            System.arraycopy(memory,start+1,narray,start+1,size);
            memory = narray;
            length = capacity;
        }
    }
    public void addFirst(T item)
    {
        if(size == length)
        {
            resize(2*size);
        }
        memory[start]=item;
        start -= 1;
        start = start%length;
        size += 1;
    }
    public void addLast(T item)
    {
        if(size == length)
        {
            resize(2*size);
        }
        memory[top] = item;
        top += 1;
        top = top%length;
        size += 1;
    }
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        return false;
    }
    public int size()
    {
        return size;
    }
    public void printDeque()
    {
        for(int i = start+1; i < length; i++)
        {
            System.out.print(memory[i] + " ");
        }
        for(int i = 0; i < top; i++)
        {
            System.out.print(memory[i] + " ");
        }
    }
    public T removeFirst()
    {
        T result;
        start += 1;
        start %= length;
        result = memory[start];
        memory[start] = null;
        size -= 1;
        if(size*4 <= length)
            resize(length/2);
        return result;
    }
    public T removeLast()
    {
        T result;
        top -= 1;
        top %= length;
        result = memory[top];
        memory[top] = null;
        size -= 1;
        if(size*4 <= length)
            resize(length/2);
        return result;
    }
    public T get(int index)
    {
        if(index >= size)
            return null;
        else
        {
           return memory[(start+1+index)%length];
        }
    }
}
