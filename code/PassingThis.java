/**
 * 定义类时，尚未new出对象，this用来指代 “调用方法的那个对象” 的引用；
 * 方法通过使用this关键字，返回调用本方法的引用；
 */

public class PassingThis{  
    public static void main(String[] args){
        new Person().eat(new Apple());
    }
}/*output:
    Remove skin
    Eat peeled apple
*/


//第一种方式：

class Person{
    void eat(Apple apple){
        Apple peeledApple = apple.peelOff();   
        System.out.println("Eat peeled apple");
    }
}
class Apple{
    Apple peelOff(){
        // ...remove peel
        System.out.println("Remove skin");
        return this;     //返回一个peeled apple
    }
}

/*第二种方式：
class Person{
    void eat(Apple apple){
        Apple peeledApple = apple.peelOff();   
        System.out.println("Eat peeled apple");
    }
}
class Peeler{
    static Apple peelOff(Apple apple){
        //...remove peel
        return apple;
    }
}
class Apple{
    Apple getPeeled()   {   return Peeler.peelOff(this); }
}
*/