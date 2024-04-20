import java.lang.foreign.SymbolLookup;

public class ArrayDeque<T>
{
    private int size;
    private int start,top;
    private T[] memory ;
    private int length;
    public ArrayDeque()
    {
        length = 8;
        size = 0;
        start = 1;
        top = 0;
        memory = (T[]) new Object[8];
    }
    private int plusone(int index, int length)
    {
        if (index + 1 == length)
            return 0;
        return index + 1;
    }
    private int minusone(int index, int length)
    {
        if (index == 0)
            return length - 1;
        return index - 1;
    }
    private void grow()
    {
        int index1 = 0;
        int index2 = start;
        T[] newarray = (T[]) new Object[length * 2];
        for (int i = 0; i < size; i++)
        {
            newarray[index1] = memory[index2];
            index1 = plusone(index1, 2 * length);
            index2 = plusone(index2, length);
        }
        start = 0;
        top = minusone(index1, 2 * length);
        length *= 2;
        memory = newarray;
    }
    private void shrink()
    {
        int index1 = 0;
        int index2 = start;
        T[] newarray = (T[]) new Object[length / 2];
        for (int i = 0; i < size; i++)
        {
            newarray[index1] = memory[index2];
            index1 = plusone(index1, length / 2);
            index2 = plusone(index2, length);
        }
        start = 0;
        top = minusone(index1, length / 2);
        length /= 2;
        memory = newarray;
    }
    public void addFirst(T item)
    {
        if(size == length)
        {
            grow();
        }
        start = minusone(start, length);
        memory[start] = item;
        size += 1;
    }
    public void addLast(T item)
    {
        if(size == length)
        {
            shrink();
        }
        top = plusone(top, length);
        memory[top] = item;
        size += 1;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public int size()
    {
        return size;
    }
    public void printDeque()
    {
        for(int i = start; i != plusone(top, length); i = plusone(i, length))
        {
            System.out.print(memory[i] + " ");
        }
    }
    public T removeFirst()
    {
        T result = memory[start];
        memory[start] = null;
        start = plusone(start, length);
        size -= 1;
        if(size*4 < length)
        {
            shrink();
        }
        return result;
    }
    public T removeLast()
    {
        T result = memory[top];
        memory[top] = null;
        top = minusone(top, length);
        size -= 1;
        if(size*4 < length)
        {
            shrink();
        }
        return result;
    }
    public T get(int index)
    {
        if(index >= size)
            return null;
        else
        {
           return memory[(start+index)%length];
        }
    }
}
