public class ArrayDeque<T> {
    int size;
    int start,top;
    T[] memory ;
    public ArrayDeque()
    {
        size=0;
        start= memory.length-1;
        top=0;
        memory = (T[]) new Object[8];
    }
    public void resize(int capacity)
    {
        if(start+1>=top)
        {
            T[] narray = (T[]) new Object[capacity];
            System.arraycopy(memory,0,narray,0,top);
            System.arraycopy(memory,start+1,narray,capacity-memory.length+start+1,memory.length-start-1);
            memory=narray;
            start=memory.length-1-(size-top);
        }
        else
        {
            T[] narray = (T[]) new Object[capacity];
            System.arraycopy(memory,start+1,narray,start+1,size);
            memory=narray;
        }
    }
    public void addFirst(T item)
    {
        if(size== memory.length)
        {
            resize(2*size);
        }
        memory[start]=item;
        start-=1;
        start=start%memory.length;
        size+=1;
    }
    public void addLast(T item)
    {
        if(size== memory.length)
        {
            resize(2*size);
        }
        memory[top]=item;
        top+=1;
        top=top%memory.length;
        size+=1;
    }
    public boolean isEmpty()
    {
        if(size==0)
            return true;
        return false;
    }
    public int size()
    {
        return size;
    }
    public void printDeque()
    {
        for(int i=start+1;i<memory.length;i++)
        {
            System.out.print(memory[i] + " ");
        }
        for(int i=0;i<top;i++)
        {
            System.out.print(memory[i] + " ");
        }
    }
    public T removeFirst()
    {
        T result;
        start+=1;
        start%=memory.length;
        result=memory[start];
        memory[start]=null;
        size-=1;
        if(size*4<=memory.length)
            resize(memory.length/2);
        return result;
    }
    public T removeLast()
    {
        T result;
        top-=1;
        top%=memory.length;
        result=memory[top];
        memory[top]=null;
        size-=1;
        if(size*4<=memory.length)
            resize(memory.length/2);
        return result;
    }
    public T get(int index)
    {
        if(index>=size)
            return null;
        else
        {
           return memory[(start+1+index)%memory.length];
        }
    }
}
