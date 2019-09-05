import java.util.AbstractCollection;
import java.util.Iterator;

public class AbstractCollection {

    public static void main(String[] args) {
        Array1 a1 = new Array1();
        String[] str1 = new String[]{"hu","ming","lin","xia"};
        for( int i=0; i<str1.length; i++){
            a1.add(str1[i]);
        }
        System.out.println("before sorted: ");
        for(String e : a1)
            System.out.println(e);
        System.out.println(a1.size());

    }
}

class Array1 extends AbstractCollection<String> {
    private String[] str ;
    private int cap = 0;

    public Array1(){
        str = new String[10];
    }



    public boolean add(String s1){                           //*
        str[cap] = s1;
        cap++;
        return true;
    }

    public int size()   {   return cap;}

    public Iterator<String> iterator(){                       //*
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator<String> {
        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public String next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            return str[current++];
        }
    }
    /*
    public int compare(String s1,String s2){
        int value = s1.length() - s2.length();
        if(value > 0)
            return 1;
        else if(value < 0)
            return -1;
        else
            return 0;
    }
    */
}