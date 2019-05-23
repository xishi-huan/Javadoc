/****************************
 * 描述：用数组来实现栈的数据操作
 * 输出：
 * false 3
 * I
 * am
 * denghuan
 * denghuan
 * I
 ****************************/

import java.util.Iterator;
import java.util.NoSuchElementException;


/**********************************
 * 测试ArrayStack类的数据操作方式
 * 入栈：I  am  denghuan
 * 
 * pop()
 **********************************/
public class ArrayRealizeStack {
    public static void main(String[] args){
        ArrayStack<String> s = new ArrayStack();
        s.push("I");
        s.push("am");
        s.push("denghuan");
        System.out.println(s.isEmpty() + " " + s.size());

        //foreach遍历，顺序与入栈顺序相同，输出：I  am   denghuan
        for(String e : s){
            System.out.println(e);
        }
        //弹出栈顶元素
        System.out.println(s.pop());
        //遍历
        for(String e : s){
            System.out.println(e);
        }
        //pop()
        System.out.println(s.pop());
    }
}
class ArrayStack<T> implements Iterable<T>{
    private T[] arr;    //用数组存储
    private int cap;    //容量

    public ArrayStack(){
        arr = (T [])new Object[2];
        cap = 0;
    }

    public boolean isEmpty()    {   return cap == 0; }
    public int size()   {   return cap; }

    //改变数组大小，数组快满时，二倍扩容，数组中元素个数等于1/4数组大小时，缩小容量
    private void reSize(int c){
        assert c > arr.length;
        T[] newArr = (T [])new Object[c];
        for(int i =0;i < cap;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void push(T e){
        arr[cap++] = e;
        if(cap == arr.length){
            reSize(2 * arr.length);
        }
    }

    public T pop(){
        T camp = arr[--cap];
        arr[cap] = null;        //防止元素游离
        if(cap <= arr.length/4){
            reSize(arr.length / 2);
        }
        return camp;
    }
    public Iterator<T> iterator(){
        return new RealizeIterator();
    }
    private class RealizeIterator implements Iterator<T>{
        int i;  //用于记录next遍历栈时的位置

        RealizeIterator(){
            i = 0; //从栈底开始遍历
        }

        public boolean hasNext()    {   return i < cap; }

        public T next(){
            if(!hasNext())
                throw new NoSuchElementException();
            return arr[i++];
        }
        public void remove()    {}
    }
}
