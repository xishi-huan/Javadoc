/**
 * 描述：模拟20次硬币投掷，输出结果
 * 输出：反 正 正 反 反 正 反 正 正 正 正 正 正 正 反 正 反 正 反 正
 */

import java.util.*;
public class RandomTest {
    public static void main(String[] args){
        Random rand = new Random();
        int value = 0;
        for(int i=0;i < 20;i++){
            value = rand.nextInt(10);
            if(value < 5)
                System.out.print("反 ");
            else
                System.out.print("正 ");
        }
    }
}