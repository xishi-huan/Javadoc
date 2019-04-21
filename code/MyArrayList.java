/**************************
 * ArrayList<T>类的实现代码
 **************************/
public class MyArrayList<T> implements Iterable<T>
{
    private static final int DEFAULT_CAPACITY=10;
    //数组列表的长度
    private int theSize; 
    //存储列表的数组
    private T[] theItems;

    public MyArrayList()
    {   doClear();}
    public void clear()
    {   doClear();}

    private void doClear()
    {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }
    public int size()
    {
        return theSize;
    }
    public boolean isEmpty()
    {   return size() == 0;}
    public void trimToSize()
    {
        ensureCapacity(size());
    }
    public T get(int idx)
    {
        if(idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }
    public T set(int idx,T newVal)
    {
        if(idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    //扩充容量
    public void ensureCapacity(int newCapacity)
    {
        if(newCapacity < theSize)
            return;
        T[] old = theItems;
        theItems = (T []) new Object[newCapacity];         //泛型数组的创建非法，使用类型转换来创建
        for(int i = 0;i < size();i++)
            theItems[i] = old[i];
    }
    //添加数据到表的末端
    public boolean add(T x)
    {
        add(size(),x);
        return true;
    }
    //添加数据到指定位置
    public void add(int idx,T x)
    {
        if(theItems.length == size())
            ensureCapacity(size()*2+1);
        for(int i = theSize;i > idx; i--)
            theItems[i] = theItems[i-1];
        theItems[idx] = x;
        theSize++;
    }
    public T remove(int idx)
    {
        if(idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        T removedVal = theItems[idx];
        for(int i = idx;i < theSize-1;i++)
            theItems[i] = theItems[i+1];
        theSize--;
        return removedVal;
    }
    public java.util.Iterator<T> iterator()
    {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements java.util.Iterator<T>
    {
        private int current = 0;
        public boolean hasNext()
        {   return current < size();}
        public T next()
        {
            if(!hasNext())
                throw new java.util.NoSuchElementException();
            return theItems[current++];
        }
        public void remove()
        {
            MyArrayList.this.remove(--current);
        }
    }

}