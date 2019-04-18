/***************************************************************************************
 * Description:一个数组a[i]=i,第一次跳过一个数删除1,；第二次跳过两个数删除4；第三次跳过三个数，删除8.....
 * 调到末尾的时候，转到数组首部继续，直到剩下一个数，输出
 * Input:0,1,2,3,4,5,6,7,8,9
 * Output:9
 *****************************************************************************************/
import java.util.*;
public class ListIterator{
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = i;
        List<Integer> list = new LinkedList<>();
        for (int e : array)
            list.add(e);
        System.out.println(list);
        Iterator<Integer> it = list.iterator();
        int t=2;       //控制迭代次数
        for (int i = 0; i < array.length-1; i++)
        {
            for(int j=0;j<t;j++)
            {
                if (it.hasNext())
                    it.next();
                else{
                    it = list.iterator();
                    it.next();
                }
            }
            t++;
            it.remove();
        }
        System.out.println(list.get(0));
    }
}