import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class TestDemo {

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

        String[] str2 = a1.getStr();
        System.out.println(Arrays.toString(str2));
        /**
         * sort中的第二个比较器参数，可以有很多种形式：提供实现Comparator<T></>接口的实例类对象；
         * 提供lambda表达式；
         * 提供new Comparator<String></>() { ...//直接实现compare方法}
         */
        Arrays.sort(a1.getStr(),a1);
        for(String e : a1)
            System.out.println(e);

        Iterator<String> iter = a1.iterator();
        iter.next();
        System.out.println(iter.next());
    }
}

/**
 * AbstractCollection<T>抽象类实现了Collection接口，提供了它的众多方法，只将size和iterator抽象化了，所以
 *可以写集合类时来extends此方法
 */
class Array1 extends AbstractCollection<String>
                        implements Comparator<String>{        //这种类似数组的集合类，实现Comparator<T>接口以后，可使用Arrays.sort(T[] ,Comparator<? super T>)排序
    private String[] str ;
    private int cap = 0;       //记录实际数据容量

    public Array1(){
        str = new String[4];                                 //待改进
    }

    public String[] getStr(){
        return str;
    }

    public boolean add(String s1){                            //
        for(String s : str)
            if(s1 == s )
                return false;
        str[cap] = s1;
        cap++;
        return true;
    }

    public int size()   {   return cap;}

    public Iterator<String> iterator(){                       //复制粘贴，待掌握
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

    /**
     * 类数据成员是String[]类型，不add值 或者 add部分值 ，其余默认初始化为null,调用这一对象数组，会抛出java.lang.NullPointerException
     * @param s1
     * @param s2
     * @return
     */
    public int compare(String s1,String s2){
        return s1.length()-s2.length();
    }
}