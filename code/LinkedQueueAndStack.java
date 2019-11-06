import java.util.*;

public class LinkedQueueAndStack {

    public static void main(String[] args) {
        LinkedQueue<String> stringQueue= new LinkedQueue<>();
        stringQueue.enqueue("one");
        stringQueue.enqueue("two");
        stringQueue.enqueue("three");


        Iterator<String> iter = stringQueue.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
/*class StdStack<E>
            implements Iterable<E>{
    private E[] a;
    private int n = 0;

    public StdStack(){
        a = (E[]) new Object[1];
    }
    public boolean isEmpty(){
        return n == 0;
    }
    public int size(){
        return n;
    }
    private void resize(int newCapa){
        E[] temp = (E[]) new Object[newCapa];
        for(int i=0; i < n; i++){
            temp[i] = a[i];
        }
        a = temp;
    }


    public void push(E e){
        if(n == a.length)
            resize(2 * a.length);
        a[n ++] = e;
    }
    public E pop(){
        n--;
        E e1 = a[n];
        a[ n+1] = null;
        if(n > 0 && n == a.length/4)
            resize(a.length/2);
        return e1;
    }
    public Iterator<E> iterator(){
        return new StdStackIterator();
    }
    private class StdStackIterator implements Iterator<E>{
        private int current = n;

        public boolean hasNext()    {   return current > 0;}
        public E next()     {   return a[--current];}
        public void remove()  {}
    }

}

class LinkedStack<Item> implements Iterable<Item>{
    private int n;
    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    LinkedStack(){
        n = 0;
        first = null;
    }
    void push(Item item){
        if(first == null){
            first = new Node();
            first.item = item;
            first.next = null;
        }else{
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }
        n++;
    }
    public Item pop(){
        if(n == 0)      throw new NoSuchElementException();
        Item x = first.item;
        first = first.next;
        n--;
        return x;
    }

    public boolean isEmpty()        { return n == 0; }
    public int size()               { return n; }


    public Iterator<Item> iterator()        {   return new LinkedStackIterator(); }
    private class LinkedStackIterator implements Iterator<Item>{
        private Node x;

        private LinkedStackIterator()    { x = first; }

        public boolean hasNext()    {   return x != null; }
        public Item next(){
            if(!hasNext())  throw new NoSuchElementException();
            Item it = x.item;
            x = x.next;
            return it;
        }
        public void remove()    {}
    }

    void printElement(){
        for(Node x =first; x != null; x = x.next){
            System.out.println(x.item);
        }
    }
}*/
class LinkedQueue<Item> implements Iterable<Item>{
    private int n = 0;
    private Node first;
    private Node last;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty()    { return first == null;}
    public int size()           {   return n;}

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())   first = last;
        else
            oldlast.next = last;
        n++;
        /*if(n == 0){
            last = new Node();
            last.item = item;
            last.next = null;
            first = last;
            n++;
        }
        else {
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            oldlast.next = last;
            n++;
        }*/
    }
    public Item dequeue(){
        Item x = first.item;
        first = first.next;
        if(isEmpty())   last = null;
        n--;
        return x;
    }
    public Iterator<Item> iterator()    {   return new LinkedQueueIterator(); }
    private class LinkedQueueIterator implements Iterator<Item>{
        private Node x = first;
        public boolean hasNext()    {   return n != 0;  }
        public Item next(){
            if(!hasNext())  throw new NoSuchElementException();
            Item it = x.item;
            x = x.next;
            return it;
        }
        public void remove()    {}

    }
}