import java.time.LocalDate;
class Pair<T>
{
    private T t1;
    private T t2;
    public Pair(T t1,T t2)
    {
        this.t1 = t1;
        this.t2 = t2;
    }
    public T getT1()
    {
        return t1;
    }
    public T getT2()
    {
        return t2;
    }
}
class ArrayAlg
{
    public static <T extends Comparable> Pair<T> minmax(T[] array)
    {
        T min=array[0];
        T max=array[0];
        for(int i=1;i<array.length;i++)
        {
            if(min.compareTo(array[i]) > 0)  min = array[i];
            if(max.compareTo(array[i]) < 0)  max = array[i];
        }
        return new Pair<>(min,max);
    }
}

class Employee implements Comparable<Employee>
{
    private String name;
    private double salary;
    private LocalDate hireDate;

    public Employee(String name,double salary,int year,int month,int day)
    {
        this.name = name;
        this.salary = salary;
        hireDate = LocalDate.of(year,month,day);
    }
    public String getName() {return name;}
    public double getSalary()   {return salary;}
    public LocalDate getHireDate() {return hireDate;}

    public int compareTo(Employee other)
    {
        return Double.compare(salary,other.salary);
    }
}
public  class MinMaxTest
{
    public static void main(String[] args)
    {
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("Tom",3000,2012,4,4);
        staff[1] = new Employee("Peter",4000,2013,3,2);
        staff[2] = new Employee("Andy",5000,2000,8,23);
        staff[3] = new Employee("Jerry",2000,1998,11,20);  
        System.out.println(ArrayAlg.minmax(staff).getT1().getName());
        System.out.println(ArrayAlg.minmax(staff).getT2().getName());
    }
}